package com.sprintplanning.au.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class Sprint.
 * 
 * @author Gowsalya SG
 */
public class Sprint {

	/** The sprint id. */
	private String id;

	/** The sprint name. */
	private String name;

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** The project id. */
	private String projectId;

	/** The generated date. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date generatedDate;

	/** The sprint days. */
	private int sprintDays;
	
	/** The sprint tasks. */
	private List<DeveloperTask> sprintTasks;

	
	/**
	 * Gets the sprint tasks.
	 *
	 * @return the sprint tasks
	 */
	public List<DeveloperTask> getSprintTasks() {
		return sprintTasks;
	}

	/**
	 * Sets the sprint tasks.
	 *
	 * @param sprintTasks the new sprint tasks
	 */
	public void setSprintTasks(List<DeveloperTask> sprintTasks) {
		this.sprintTasks = sprintTasks;
	}

	/**
	 * Instantiates a new sprint.
	 */
	public Sprint() {
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Instantiates a new sprint.
	 *
	 * @param name          the sprint name
	 * @param projectId     the project id
	 * @param generatedDate the generated date
	 * @param sprintDays    the sprint days
	 */
	public Sprint(String name, String projectId, Date generatedDate, int sprintDays) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.projectId = projectId;
		this.generatedDate = generatedDate;
		this.sprintDays = sprintDays;
	}

	/**
	 * Gets the sprint id.
	 *
	 * @return the sprint id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the sprint name.
	 *
	 * @return the sprint name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the sprint name.
	 *
	 * @param name the new sprint name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId the new project id
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the generated date.
	 *
	 * @return the generated date
	 */
	public Date getGeneratedDate() {
		return generatedDate;
	}

	/**
	 * Sets the generated date.
	 *
	 * @param generatedDate the new generated date
	 */
	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
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
		return "Sprint [id=" + id + ", name=" + name + ", projectId=" + projectId + ", generatedDate=" + generatedDate
				+ ", sprintDays=" + sprintDays + "]";
	}
}
