package com.sprintplanning.au.model;

/**
 * The Class AdminProject.
 * 
 * @author Gowsalya SG
 */
public class AdminProject {

	/** The project id. */
	private int projectId;

	/** The user id. */
	private int userId;

	/**
	 * Instantiates a new admin project.
	 */
	public AdminProject() {

	}

	/**
	 * Instantiates a new admin project.
	 *
	 * @param projectId the project id
	 * @param userId    the user id
	 */
	public AdminProject(int projectId, int userId) {

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
