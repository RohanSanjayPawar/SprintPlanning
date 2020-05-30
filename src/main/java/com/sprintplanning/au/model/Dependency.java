package com.sprintplanning.au.model;

/**
 * The Class Dependency.
 * 
 * @author Gowsalya SG
 */
public class Dependency {

	/** The task id. */
	private String taskId;

	/** The dependency id. */
	private String dependencyId;

	/**
	 * Instantiates a new dependency.
	 */
	public Dependency() {

	}

	/**
	 * Instantiates a new dependency.
	 *
	 * @param taskId       the task id
	 * @param dependencyId the dependency id
	 */
	public Dependency(String taskId, String dependencyId) {
		this.taskId = taskId;
		this.dependencyId = dependencyId;
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
	 * Gets the dependency id.
	 *
	 * @return the dependency id
	 */
	public String getDependencyId() {
		return dependencyId;
	}

	/**
	 * Sets the dependency id.
	 *
	 * @param dependencyId the new dependency id
	 */
	public void setDependencyId(String dependencyId) {
		this.dependencyId = dependencyId;
	}

}
