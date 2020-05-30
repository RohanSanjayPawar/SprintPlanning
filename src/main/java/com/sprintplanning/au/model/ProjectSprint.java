package com.sprintplanning.au.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class ProjectSprint.
 * 
 * @author Rohan Pawar
 */
public class ProjectSprint {

	/** The project id. */
	private String projectId;
	
	/** The sprints. */
	private List<Sprint> sprints;
	
	/** The generated date. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date generatedDate;
	
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
	 * Gets the sprints.
	 *
	 * @return the sprints
	 */
	public List<Sprint> getSprints() {
		return sprints;
	}
	
	/**
	 * Sets the sprints.
	 *
	 * @param sprints the new sprints
	 */
	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ProjectSprint [projectId=" + projectId + ", sprints=" + sprints + ", generatedDate=" + generatedDate
				+ "]";
	}
	
	
}
