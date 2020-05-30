package com.sprintplanning.au.model;

/**
 * The Class Configuration.
 * 
 * @author Rohan Pawar
 */
public class Configuration {
	/** The sprint id. */
	private String sprintId;
	
	/** The sprint days. */
	private int sprintDays;
	
	
	/**
	 * Instantiates a new configuration.
	 */
	public Configuration()
	{
		
	}

	/**
	 * Instantiates a new configuration.
	 *
	 * @param sprintId the sprint id
	 * @param sprintDays the sprint days
	 */
	public Configuration(String sprintId, int sprintDays) {
		super();
		this.sprintId = sprintId;
		this.sprintDays = sprintDays;
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
	 * Gets the sprint days.
	 *
	 * @return the sprint days
	 */
	public int getSprintDays() {
		return sprintDays;
	}

	/**
	 * Sets the sprint days.
	 *
	 * @param sprintDays the new sprint days
	 */
	public void setSprintDays(int sprintDays) {
		this.sprintDays = sprintDays;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Configuration [sprintId=" + sprintId + ", sprintDays=" + sprintDays + "]";
	}

}
