package com.sprintplanning.au.filters;

import static java.time.temporal.ChronoUnit.WEEKS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sprintplanning.au.model.Dependency;
import com.sprintplanning.au.model.DeveloperTask;
import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.model.ProjectSprint;
import com.sprintplanning.au.model.Sprint;
import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.model.UserModel;

/**
 * The Class SchedulerFilter.
 * 
 * @author Rohan Pawar
 */
public class SchedulerFilter {

	/**
	 * Gets the total hours.
	 *
	 * @param userPool the user pool
	 * @return the total hours
	 */
	public double getTotalHours(List<UserModel> userPool) {
		double totalHours = 0;
		for (UserModel user : userPool) {
			totalHours += user.getWorkHours();
		}
		return totalHours;
	}

	/**
	 * Total task hours.
	 *
	 * @param sortedTask the sorted task
	 * @return the double
	 */
	public double totalTaskHours(List<Task> sortedTask) {
		double totalHours = 0;
		for (Task task : sortedTask) {
			totalHours += task.getHours();
		}
		return totalHours;
	}

	/**
	 * Checks if is assigned.
	 *
	 * @param taskList the task list
	 * @return true, if is assigned
	 */
	public boolean isAssigned(List<Task> taskList) {
		for (Task task : taskList) {
			if (!task.isAssigned()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Queue generator.
	 *
	 * @param project        the project
	 * @param taskList       the task list
	 * @param userList       the user list
	 * @param dependencyList the dependency list
	 * @param sprintDuration the sprint duration
	 * @return the project sprint
	 */
	public ProjectSprint queueGenerator(ProjectModel project, List<Task> taskList, List<UserModel> userList,
			List<Dependency> dependencyList, double sprintDuration) {
		TaskFilters taskFilters = new TaskFilters();
		SprintFilters sprintFilters = new SprintFilters();
		
		double sprintWeeks = WEEKS.between(project.getStartDate().toLocalDate(), project.getEstimatedEndDate().toLocalDate());
		for(UserModel user: userList) {
			if(sprintWeeks == 0)
				user.setWorkHours(user.getWorkHours()*(sprintWeeks+1));
			else
				user.setWorkHours(user.getWorkHours()*sprintWeeks);
		}
		
		/**
		 * Basic check: if the number of hours the user is available is less than the
		 * number of hours the task requires
		 */
		double totalUserHours = getTotalHours(userList);
		double totalTaskHours = totalTaskHours(taskList);
		
		if (totalTaskHours > totalUserHours) {
			return new ProjectSprint();
		}

		HashMap<String, Task> taskMap = (HashMap<String, Task>) taskFilters.dependencyTaskMapper(taskList,
				dependencyList);

		PriorityQueue<Task> taskQueue = (PriorityQueue<Task>) taskFilters.taskFilter(taskMap);
		PriorityQueue<UserModel> userQueue = (PriorityQueue<UserModel>) sprintFilters.sortByHours(userList);
		return generateSprints(project, taskQueue, userQueue, sprintDuration);
	}

	/**
	 * Generate sprints.
	 *
	 * @param project        the project
	 * @param taskQueue      the task queue
	 * @param userQueue      the user queue
	 * @param sprintDuration the sprint duration
	 * @return the project sprint
	 */
	public ProjectSprint generateSprints(ProjectModel project, Queue<Task> taskQueue, Queue<UserModel> userQueue,
			double sprintDuration) {

		List<DeveloperTask> developerTasks = new ArrayList<>();
		List<Sprint> sprintList = new ArrayList<>();
		
		Date startDate = project.getStartDate();
		Date generatedDate = project.getStartDate();
		int count = 0;
		double hoursDuration = sprintDuration * 10.0;
		int devCount = 0;
		while (!userQueue.isEmpty()) {
			UserModel user = userQueue.poll();
			double workingHours = user.getWorkHours();
			while (!taskQueue.isEmpty()) {
				Task currentTask = taskQueue.poll();
				if (!currentTask.isAssigned() && hoursDuration >= currentTask.getHours() && user.getWorkHours() > 0) {
					if (currentTask.getHours() <= user.getWorkHours()) {
						user.setWorkHours(user.getWorkHours() - currentTask.getHours());
						currentTask.setAssigned(true);
						workingHours = currentTask.getHours();
						user.setAssignedTasks(user.getAssignedTasks()+1);
						userQueue.add(user);
						hoursDuration -= workingHours;
						user = userQueue.poll();
					} else if (user.getWorkHours() != 0) {
						currentTask.setHours(currentTask.getHours() - user.getWorkHours());
						user.setWorkHours(0.0);
						user.setAssignedTasks(user.getAssignedTasks()+1);
						hoursDuration -= user.getWorkHours();
					}
					// Create a Dev-task object (MAKE API CALL)
					DeveloperTask developerTask = new DeveloperTask();
					developerTask.setDeveloperTaskId(currentTask.getId() + "-" + user.getId() + "-" + devCount);
					devCount++;
					developerTask.setUserId(user.getId());
					developerTask.setTaskId(currentTask.getId());
					developerTask.setEstimatedHours(workingHours);
					
					developerTask.setStartDate(startDate);
					long start = startDate.getTime();
					long daysForStart = (long)workingHours/10;
					long duration = daysForStart*24*60*60*1000;
					start += duration;
					Date endDate = new Date(start);
					developerTask.setEndDate(endDate);
					startDate = endDate;
					
					System.out.println(developerTask);
					
					developerTasks.add(developerTask);
				}
				if (checkSprintCondition(taskQueue, hoursDuration)) {
					Sprint sprint = makeSprint(project, generatedDate, count, developerTasks, sprintDuration);
					developerTasks = new ArrayList<>();
					count++;
					sprintList.add(sprint);
					hoursDuration = sprintDuration * 10.0;
				}
			}
		}

		ProjectSprint projectSprint = new ProjectSprint();
		projectSprint.setProjectId(project.getId());
		projectSprint.setSprints(sprintList);
		long currentTime = System.currentTimeMillis();
		projectSprint.setGeneratedDate(new Date(currentTime));

		return projectSprint;
	}
	
	/**
	 * Make sprint.
	 *
	 * @param project the project
	 * @param generatedDate the generated date
	 * @param count the count
	 * @param developerTasks the developer tasks
	 * @param sprintDuration the sprint duration
	 * @return the sprint
	 */
	public Sprint makeSprint(ProjectModel project, Date generatedDate, int count, List<DeveloperTask> developerTasks, double sprintDuration) {
		Sprint sprint = new Sprint();
		sprint.setGeneratedDate(generatedDate);
		sprint.setProjectId(project.getId());
		sprint.setName(project.getId() + "-" + count);
		sprint.setSprintDays((int) sprintDuration);

		for (DeveloperTask developerTask : developerTasks) {
			developerTask.setSprintId(sprint.getId());
		}
		sprint.setSprintTasks(developerTasks);
		return sprint;
	}
	
	/**
	 * Check sprint condition.
	 *
	 * @param taskQueue the task queue
	 * @param hoursDuration the hours duration
	 * @return true, if successful
	 */
	public boolean checkSprintCondition(Queue<Task> taskQueue, double hoursDuration) {
		return taskQueue.isEmpty() || hoursDuration < taskQueue.peek().getHours();
	}
}
