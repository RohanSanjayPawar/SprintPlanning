package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.ProjectModel;

/**
 * The Interface ProjectDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface ProjectDAO {

	/**
	 * Gets the all projects.
	 *
	 * @return the all projects
	 */
	public List<ProjectModel> getAllProjects();
	
	/**
	 * Gets the project from id.
	 *
	 * @return the project from id
	 */
	public ProjectModel getProjectFromId(String projectId);
	
}
