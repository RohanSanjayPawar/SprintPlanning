package com.sprintplanning.au.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class GlobalHoliday.
 * 
 * @author Rohan Pawar
 */
public class GlobalHoliday {
	
	/** The date of holiday. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfHoliday;
	
	/** The holiday description. */
	private String holidayDescription;

	/**
	 * Instantiates a new holiday.
	 */
	public GlobalHoliday() {

	}

	/**
	 * Instantiates a new holiday.
	 *
	 * @param dateOfHoliday the date of holiday
	 * @param holidayDescription the holiday description
	 */
	public GlobalHoliday(Date dateOfHoliday, String holidayDescription) {
		this.dateOfHoliday = dateOfHoliday;
		this.holidayDescription = holidayDescription;
	}

	/**
	 * Gets the date of holiday.
	 *
	 * @return the date of holiday
	 */
	public Date getDateOfHoliday() {
		return dateOfHoliday;
	}

	/**
	 * Sets the date of holiday.
	 *
	 * @param dateOfHoliday the new date of holiday
	 */
	public void setDateOfHoliday(Date dateOfHoliday) {
		this.dateOfHoliday = dateOfHoliday;
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

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Holiday [dateOfHoliday=" + dateOfHoliday + ", holidayDescription=" + holidayDescription + "]";
	}
}