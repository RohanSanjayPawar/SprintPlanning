package com.sprintplanning.au;

import java.util.List;

import com.sprintplanning.au.filters.FetchFilters;
import com.sprintplanning.au.filters.SchedulerFilter;
import com.sprintplanning.au.filters.SprintFilters;
import com.sprintplanning.au.filters.TaskFilters;
import com.sprintplanning.au.model.Dependency;
import com.sprintplanning.au.model.GlobalHoliday;
import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.model.ProjectSprint;
import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.model.UserModel;

/**
 * The Class SprintGenerator.
 * 
 * @author Rohan Pawar
 */
public class SprintGenerator {
	
	/**
	 * Generate sprint.
	 *
	 * @param projectId the project id
	 */
	public ProjectSprint generateSprint(String projectId) {
		FetchFilters fetchFilters = new FetchFilters();
		SprintFilters sprintFilters = new SprintFilters();
		TaskFilters taskFilters = new TaskFilters();
		SchedulerFilter schedulerFilter = new SchedulerFilter();
		
		/**
		 *  Get the project object from the Databases
		 * */
		ProjectModel project = fetchFilters.getProjectById(projectId);
		
		/**
		 *  Fetch the user pool that the admin selected for the Project
		 * */
		List<UserModel> userPool = fetchFilters.filterUsers(projectId);
		/**
		 *  Fetch the list of Global Holidays and Developer Leaves for filtering
		 * */
		List<GlobalHoliday> globalHolidays = fetchFilters.getAllHolidays();
		
		List<UserModel> filteredUsersOnHolidays = sprintFilters.filterOnHoliday(userPool, globalHolidays, project);
		
		/**
		 *  Fetch all the tasks generated for the project with projectID
		 *  
		 *  @param Project ID
		 * */
		List<Task> allTasks = taskFilters.getAllTasks(projectId);
		
		List<Dependency> dependencyList = fetchFilters.getAllDependencies(projectId);
		
		double sprintDuration = sprintFilters.getSprintDuration();
		
		return schedulerFilter.queueGenerator(project, allTasks, filteredUsersOnHolidays, dependencyList, sprintDuration);
	}
}

