package com.sprintplanning.au.constants;

/**
 * The Class DeveloperHoursConstants.
 * 
 * @author Rohan Pawar
 */
public class DeveloperHoursConstants {
	
	/** The Constant USER_HOURS. */
	private static final double USER_HOURS = 50.0;
	
	/** The Constant DAILY_HOURS. */
	private static final double DAILY_HOURS = 10.0;
	
	/**
	 * Gets the user hours.
	 *
	 * @return the user hours
	 */
	public static double getUserHours() {
		return USER_HOURS;
	}
	
	/**
	 * Gets the daily hours.
	 *
	 * @return the daily hours
	 */
	public static double getDailyHours() {
		return DAILY_HOURS;
	}
	
	/**
	 * Instantiates a new developer hours constants.
	 */
	private DeveloperHoursConstants() {
		
	}
}
