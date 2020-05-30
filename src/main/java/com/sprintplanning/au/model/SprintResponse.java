package com.sprintplanning.au.model;

/**
 * The Class SprintResponse.
 * 
 * @author Rohan Pawar
 */
public class SprintResponse {
	
	/** The message. */
	private String message;
	
	/** The project sprint. */
	private ProjectSprint projectSprint;
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets the project sprint.
	 *
	 * @return the project sprint
	 */
	public ProjectSprint getProjectSprint() {
		return projectSprint;
	}
	
	/**
	 * Sets the project sprint.
	 *
	 * @param projectSprint the new project sprint
	 */
	public void setProjectSprint(ProjectSprint projectSprint) {
		this.projectSprint = projectSprint;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SprintResponse [message=" + message + ", projectSprint=" + projectSprint + "]";
	}
	
	
}
