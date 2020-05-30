package com.sprintplanning.au.constants;

/**
 * The Class ConfigurationModelConstants.
 * 
 * @author Rohan Pawar
 */
public class ConfigurationModelConstants {
	
	/** The Constant SPRINT_DAYS. */
	private static final String SPRINT_DAYS = "SPRINT_DAYS";
	
	/** The Constant SPRINT_ID. */
	private static final String SPRINT_ID = "SPRINT_ID";

	/**
	 * Gets the sprint id.
	 *
	 * @return the sprint id
	 */
	public static String getSprintId() {
		return SPRINT_ID;
	}

	/**
	 * Gets the sprint days.
	 *
	 * @return the sprint days
	 */
	public static String getSprintDays() {
		return SPRINT_DAYS;
	}
	
	/**
	 * Instantiates a new configuration model constants.
	 */
	private ConfigurationModelConstants() {
		
	}

}
