package com.sprintplanning.au.queries;

/**
 * The Class TaskModelQueries.
 * 
 * @author Rohan Pawar
 */
public class TaskModelQueries {
	
	/** The Constant GET_ALL_TASKS_FOR_PROJECTS. */
	private static final String GET_ALL_TASKS_FOR_PROJECTS = "SELECT * FROM TASKS WHERE PROJECT_ID =";
	
	/** The Constant GET_ALL_TASKS. */
	private static final String GET_ALL_TASKS = "SELECT * FROM TASKS";

	/**
	 * Gets the gets the all tasks.
	 *
	 * @return the gets the all tasks
	 */
	public static String getGetAllTasks() {
		return GET_ALL_TASKS;
	}

	/**
	 * Gets the gets the all tasks for projects.
	 *
	 * @return the gets the all tasks for projects
	 */
	public static String getGetAllTasksForProjects() {
		return GET_ALL_TASKS_FOR_PROJECTS;
	} 
	
	/**
	 * Instantiates a new task model queries.
	 */
	private TaskModelQueries() {
		
	}
}
