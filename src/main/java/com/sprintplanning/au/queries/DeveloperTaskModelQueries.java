package com.sprintplanning.au.queries;

/**
 * The Class DeveloperTaskModelQueries.
 * 
 * @author Rohan Pawar
 */
public class DeveloperTaskModelQueries {

	/** The Constant ADD_DEVELOPER_TASK. */
	private static final String ADD_DEVELOPER_TASK = "INSERT INTO DEVELOPER_TASKS("
			+ "DEVELOPER_TASK_ID, USER_ID, TASK_ID, ESTIMATED_HOURS, SPRINT_ID) VALUES(?, ?, ?, ?, ?)";
	
	/** The Constant SET_DATES_FOR_TASK. */
	private static final String SET_DATES_FOR_TASK = "UPDATE TASKS SET TASK_START_DATE = ?, TASK_END_DATE = ? WHERE TASK_ID = ?";
	
	/**
	 * Gets the sets the dates for task.
	 *
	 * @return the sets the dates for task
	 */
	public static String getSetDatesForTask() {
		return SET_DATES_FOR_TASK;
	}

	/**
	 * Gets the adds the developer task.
	 *
	 * @return the adds the developer task
	 */
	public static String getAddDeveloperTask() {
		return ADD_DEVELOPER_TASK;
	}

	/**
	 * Instantiates a new developer task model queries.
	 */
	private DeveloperTaskModelQueries() {

	}
}
