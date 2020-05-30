package com.sprintplanning.au.model;

import java.sql.Date;

/**
 * The Class WorkHistory.
 * 
 * @author Rohan Pawar
 */
public class WorkHistory {
	
	/** The working date. */
	private Date workingDate;
	
	/** The developer task id. */
	private int developerTaskId;
	
	/** The working hours. */
	private int workingHours;

	/**
	 * Instantiates a new work history.
	 */
	public WorkHistory() {

	}

	/**
	 * Instantiates a new work history.
	 *
	 * @param workingDate the working date
	 * @param developerTaskId the developer task id
	 * @param workingHours the working hours
	 */
	public WorkHistory(Date workingDate, int developerTaskId, int workingHours) {
		this.workingDate = workingDate;
		this.developerTaskId = developerTaskId;
		this.workingHours = workingHours;
	}

	/**
	 * Gets the working date.
	 *
	 * @return the working date
	 */
	public Date getWorkingDate() {
		return workingDate;
	}

	/**
	 * Sets the working date.
	 *
	 * @param workingDate the new working date
	 */
	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}

	/**
	 * Gets the developer task id.
	 *
	 * @return the developer task id
	 */
	public int getDeveloperTaskId() {
		return developerTaskId;
	}

	/**
	 * Sets the developer task id.
	 *
	 * @param developerTaskId the new developer task id
	 */
	public void setDeveloperTaskId(int developerTaskId) {
		this.developerTaskId = developerTaskId;
	}

	/**
	 * Gets the working hours.
	 *
	 * @return the working hours
	 */
	public int getWorkingHours() {
		return workingHours;
	}

	/**
	 * Sets the working hours.
	 *
	 * @param workingHours the new working hours
	 */
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "WorkHistory [workingDate=" + workingDate + ", developerTaskId=" + developerTaskId + ", workingHours="
				+ workingHours + "]";
	}

}
