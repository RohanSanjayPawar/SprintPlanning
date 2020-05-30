package com.sprintplanning.au.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* The Class DeveloperTask.
* 
* 
*/
public class DeveloperTask {

	/* The developer task id. */
	private String developerTaskId;

	/* The user id. */
	private String userId;

	/* The task id. */
	private String taskId;

	/* The working hours. */
	private double workingHours;

	/* The estimated hours. */
	private double estimatedHours;

	/* The sprint id. */
	private String sprintId;
	
	/** The start date. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	
	/** The end date. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Instantiates a new developer task.
	 */
	public DeveloperTask() {

	}

	/**
	 * Instantiates a new developer task.
	 *
	 * @param developerTaskId the developer task id
	 * @param userId          the user id
	 * @param taskId          the task id
	 * @param workingHours    the working hours
	 * @param estimatedHours  the estimated hours
	 * @param sprintId        the sprint id
	 */
	public DeveloperTask(String developerTaskId, String userId, String taskId, double workingHours, double estimatedHours,
			String sprintId) {

		this.developerTaskId = developerTaskId;
		this.userId = userId;
		this.taskId = taskId;
		this.workingHours = workingHours;
		this.estimatedHours = estimatedHours;
		this.sprintId = sprintId;
	}

	/**
	 * Gets the developer task id.
	 *
	 * @return the developer task id
	 */
	public String getDeveloperTaskId() {
		return developerTaskId;
	}

	/**
	 * Sets the developer task id.
	 *
	 * @param developerTaskId the new developer task id
	 */
	public void setDeveloperTaskId(String developerTaskId) {
		this.developerTaskId = developerTaskId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userID the new user id
	 */
	public void setUserId(String userID) {
		this.userId = userID;
	}

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskId the new task id
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the working hours.
	 *
	 * @return the working hours
	 */
	public double getWorkingHours() {
		return workingHours;
	}

	/**
	 * Sets the working hours.
	 *
	 * @param workingHours the new working hours
	 */
	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	/**
	 * Gets the estimated hours.
	 *
	 * @return the estimated hours
	 */
	public double getEstimatedHours() {
		return estimatedHours;
	}

	/**
	 * Sets the estimated hours.
	 *
	 * @param estimatedHours the new estimated hours
	 */
	public void setEstimatedHours(double estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	/**
	 * Gets the sprint id.
	 *
	 * @return the sprint id
	 */
	public String getSprintId() {
		return sprintId;
	}

	/**
	 * Sets the sprint id.
	 *
	 * @param sprintId the new sprint id
	 */
	public void setSprintId(String sprintId) {
		this.sprintId = sprintId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DeveloperTask [developerTaskId=" + developerTaskId + ", userId=" + userId + ", taskId=" + taskId
				+ ", workingHours=" + workingHours + ", estimatedHours=" + estimatedHours + ", sprintId=" + sprintId
				+ "]";
	}
	
	

}