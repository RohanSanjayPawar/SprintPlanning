package com.sprintplanning.au.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class DeveloperLeaves.
 * 
 * @author Rohan Pawar
 */
public class DeveloperLeaves {
	
	/** The user id. */
	private String userId;
	
	/** The start da of leave. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDayOfLeave;
	
	/** The end day of leave. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDayOfLeave;
	
	/** The reason for leave. */
	private String reasonForLeave;
	
	/**
	 * Instantiates a new developer leaves.
	 */
	public DeveloperLeaves() {
		
	}
	
	/**
	 * Instantiates a new developer leaves.
	 *
	 * @param userId the user id
	 * @param startDaOfLeave the start da of leave
	 * @param endDayOfLeave the end day of leave
	 * @param reasonForLeave the reason for leave
	 */
	public DeveloperLeaves(String userId, Date startDayOfLeave, Date endDayOfLeave, String reasonForLeave) {
		this.userId = userId;
		this.startDayOfLeave = startDayOfLeave;
		this.endDayOfLeave = endDayOfLeave;
		this.reasonForLeave = reasonForLeave;
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
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the start da of leave.
	 *
	 * @return the start da of leave
	 */
	public Date getStartDayOfLeave() {
		return startDayOfLeave;
	}

	/**
	 * Sets the start da of leave.
	 *
	 * @param startDaOfLeave the new start da of leave
	 */
	public void setStartDayOfLeave(Date startDayOfLeave) {
		this.startDayOfLeave = startDayOfLeave;
	}

	/**
	 * Gets the end day of leave.
	 *
	 * @return the end day of leave
	 */
	public Date getEndDayOfLeave() {
		return endDayOfLeave;
	}

	/**
	 * Sets the end day of leave.
	 *
	 * @param endDayOfLeave the new end day of leave
	 */
	public void setEndDayOfLeave(Date endDayOfLeave) {
		this.endDayOfLeave = endDayOfLeave;
	}

	/**
	 * Gets the reason for leave.
	 *
	 * @return the reason for leave
	 */
	public String getReasonForLeave() {
		return reasonForLeave;
	}

	/**
	 * Sets the reason for leave.
	 *
	 * @param reasonForLeave the new reason for leave
	 */
	public void setReasonForLeave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DeveloperLeaves [userId=" + userId + ", startDayOfLeave=" + startDayOfLeave + ", endDayOfLeave="
				+ endDayOfLeave + ", reasonForLeave=" + reasonForLeave + "]";
	}
}
