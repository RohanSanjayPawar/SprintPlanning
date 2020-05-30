package com.sprintplanning.au.model;

/**
 * The Class DeveloperProject.
 * 
 * @author Gawslya
 */
public class DeveloperProject {

	/* The project id. */
	private int projectId;

	/* The user id. */
	private int userId;

	/**
	 * Instantiates a new developer project.
	 */
	public DeveloperProject() {

	}

	/**
	 * Instantiates a new developer project.
	 *
	 * @param projectId the project id
	 * @param userId    the user id
	 */
	public DeveloperProject(int projectId, int userId) {

		this.projectId = projectId;
		this.userId = userId;
	}

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId the new project id
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
