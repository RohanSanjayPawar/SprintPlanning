package com.sprintplanning.au.constants;

/**
 * The Class GlobalHolidayModelConstants.
 * 
 * @author Rohan Pawar
 */
public class GlobalHolidayModelConstants {
	
	/** The Constant DATE_OF_HOLIDAY. */
	private static final String DATE_OF_HOLIDAY = "DATE_OF_HOLIDAY";
	
	/** The Constant HOLIDAY_DESCRIPTION. */
	private static final String HOLIDAY_DESCRIPTION = "HOLIDAY_DESCRIPTION";

	/**
	 * Gets the date of holiday.
	 *
	 * @return the date of holiday
	 */
	public static String getDateOfHoliday() {
		return DATE_OF_HOLIDAY;
	}

	/**
	 * Gets the holiday description.
	 *
	 * @return the holiday description
	 */
	public static String getHolidayDescription() {
		return HOLIDAY_DESCRIPTION;
	}
	
	/**
	 * Instantiates a new global holiday model constants.
	 */
	private GlobalHolidayModelConstants() {
		
	}
}
