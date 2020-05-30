package com.sprintplanning.au.dao;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.ProjectSprint;
import com.sprintplanning.au.model.SprintResponse;

/**
 * The Interface ProjectSprintDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface ProjectSprintDAO {
	
	/**
	 * Insert project sprint.
	 *
	 * @param projectSprint the project sprint
	 */
	public void insertProjectSprint(ProjectSprint projectSprint);
	
	/**
	 * Gets the project sprint by id.
	 *
	 * @param projectId the project id
	 * @return the sprint response by id
	 */
	public SprintResponse getProjectSprintById(String projectId);
	
	/**
	 * Gets the project sprint weekly.
	 *
	 * @param projectId the project id
	 * @return the project sprint weekly
	 */
	public SprintResponse getProjectSprintWeekly(String projectId);
	
}
