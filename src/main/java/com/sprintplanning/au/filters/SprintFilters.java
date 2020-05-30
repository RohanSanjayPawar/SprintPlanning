package com.sprintplanning.au.filters;

import static java.time.temporal.ChronoUnit.HOURS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sprintplanning.au.constants.DeveloperHoursConstants;
import com.sprintplanning.au.model.DeveloperLeaves;
import com.sprintplanning.au.model.GlobalHoliday;
import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.model.UserModel;
import com.sprintplanning.au.service.DBConfigService;

/**
 * The Class SprintFilters.
 * 
 * @author Rohan Pawar
 */
public class SprintFilters {

	/** The fetch filters. */
	FetchFilters fetchFilters = new FetchFilters();

	/**
	 * Filter on holiday.
	 *
	 * @param userPool       the user pool
	 * @param globalHolidays the global holidays
	 * @param project        the project
	 * @return the list
	 */
	public List<UserModel> filterOnHoliday(List<UserModel> userPool, List<GlobalHoliday> globalHolidays,
			ProjectModel project) {
		List<UserModel> filteredUsers = new ArrayList<>();
		
		for(UserModel user: userPool) {
			user.setWorkHours(50.0);
		}

		for (GlobalHoliday holiday : globalHolidays) {
			if (holiday.getDateOfHoliday().compareTo(project.getStartDate()) > 0
					&& holiday.getDateOfHoliday().compareTo(project.getEstimatedEndDate()) < 0) {
				for (UserModel user : userPool) {
					if (user.getWorkHours() == 50.0) {
						double availableHours = DeveloperHoursConstants.getUserHours();
						user.setWorkHours(availableHours - DeveloperHoursConstants.getDailyHours());
					}
					filteredUsers.add(filterOnLeaves(user, project));
				}
			}
		}
		if(filteredUsers.isEmpty())
			return userPool;
		return filteredUsers;
	}

	/**
	 * Filter on leaves.
	 *
	 * @param userPool       the user pool
	 * @param globalHolidays the global holidays
	 * @param project        the project
	 * @return the list
	 */
	public UserModel filterOnLeaves(UserModel user, ProjectModel project) {
		List<DeveloperLeaves> userLeaves = fetchFilters.getAllLeavesForDeveloper(user.getId());
		double currentHours = user.getWorkHours();
		for (DeveloperLeaves leaves : userLeaves) {
			if (leaves.getStartDayOfLeave().compareTo(project.getStartDate()) < 0
					&& leaves.getEndDayOfLeave().compareTo(project.getEstimatedEndDate()) < 0
					&& leaves.getEndDayOfLeave().compareTo(project.getStartDate()) > 0) {
				double difference = HOURS.between(leaves.getEndDayOfLeave().toLocalDate(),
						project.getStartDate().toLocalDate());
				currentHours -= difference;
			} else if (leaves.getStartDayOfLeave().compareTo(project.getStartDate()) > 0
					&& leaves.getEndDayOfLeave().compareTo(project.getEstimatedEndDate()) < 0) {
				double difference = HOURS.between(leaves.getEndDayOfLeave().toLocalDate(),
						leaves.getStartDayOfLeave().toLocalDate());
				currentHours -= difference;
			} else if (leaves.getStartDayOfLeave().compareTo(project.getStartDate()) > 0
					&& leaves.getEndDayOfLeave().compareTo(project.getEstimatedEndDate()) > 0
					&& leaves.getStartDayOfLeave().compareTo(project.getEstimatedEndDate()) < 0) {
				double difference = HOURS.between(project.getEstimatedEndDate().toLocalDate(),
						leaves.getStartDayOfLeave().toLocalDate());
				currentHours -= difference;
			}
		}
		user.setWorkHours(currentHours);
		return user;
	}

	/**
	 * Sort by hours.
	 *
	 * @param userPool the user pool
	 * @return the list
	 */
	public Queue<UserModel> sortByHours(List<UserModel> userPool) {
		Comparator<UserModel> userComparator = Comparator.comparing(UserModel::getEfficiency).reversed()
				.thenComparing(UserModel::getAssignedTasks).thenComparing(UserModel::getWorkHours);
		PriorityQueue<UserModel> userQueue = new PriorityQueue<>(userComparator);

		for (UserModel user : userPool) {
			userQueue.add(user);
		}

		return userQueue;
	}
	
	/**
	 * Gets the sprint duration.
	 *
	 * @param configurationId the configuration id
	 * @return the sprint duration
	 */
	public double getSprintDuration() {
		DBConfigService dbConfigurationService = new DBConfigService();
		return dbConfigurationService.getConfigurationDAO().getConfiguration().getSprintDays();
	}
}
