package com.sprintplanning.au.constants;

/**
 * The Class WorkHistoryModelConstants.
 * 
 * @author Rohan Pawar
 */
public class WorkHistoryModelConstants {

	/** The Constant WORKING_DATE. */
	private static final String WORKING_DATE = "WORKING_DATE";
	
	/** The Constant DEVELOPER_TASK_ID. */
	private static final String DEVELOPER_TASK_ID = "DEVELOPER_TASK_ID";
	
	/** The Constant WORKING_HOURS. */
	private static final String WORKING_HOURS = "WORKING_HOURS";
	
	/**
	 * Gets the working date.
	 *
	 * @return the working date
	 */
	public static String getWorkingDate() {
		return WORKING_DATE;
	}
	
	/**
	 * Gets the developer task id.
	 *
	 * @return the developer task id
	 */
	public static String getDeveloperTaskId() {
		return DEVELOPER_TASK_ID;
	}
	
	/**
	 * Gets the working hours.
	 *
	 * @return the working hours
	 */
	public static String getWorkingHours() {
		return WORKING_HOURS;
	}
	
	/**
	 * Instantiates a new work history model constants.
	 */
	private WorkHistoryModelConstants() {
		
	}
}
