package com.sprintplanning.au.model;

import java.sql.Date;

/**
 * The Class HolidayGlobal.
 * 
 * @author Gowsalya SG
 */
public class HolidayGlobal {
	
	/** The date of holidays. */
	private Date dateOfHolidays;
	 
	/** The holiday description. */
	private String holidayDescription;
	
	/**
	 * Instantiates a new holiday global.
	 * 
	 */

	public HolidayGlobal()
	{
		
	}

	/**
	 * Instantiates a new holiday global.
	 *
	 * @param dateOfHolidays the date of holidays
	 * @param holidayDescription the holiday description
	 */
	public HolidayGlobal(Date dateOfHolidays, String holidayDescription) {
		this.dateOfHolidays = dateOfHolidays;
		this.holidayDescription = holidayDescription;
	}

	/**
	 * Gets the date of holidays.
	 *
	 * @return the date of holidays
	 */
	public Date getDateOfHolidays() {
		return dateOfHolidays;
	}

	/**
	 * Sets the date of holidays.
	 *
	 * @param dateOfHolidays the new date of holidays
	 */
	public void setDateOfHolidays(Date dateOfHolidays) {
		this.dateOfHolidays = dateOfHolidays;
	}

	/**
	 * Gets the holiday description.
	 *
	 * @return the holiday description
	 */
	public String getHolidayDescription() {
		return holidayDescription;
	}

	/**
	 * Sets the holiday description.
	 *
	 * @param holidayDescription the new holiday description
	 */
	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
	}
	
    
}

