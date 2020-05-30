package com.sprintplanning.au.queries;

/**
 * The Class ProjectModelQueries.
 * 
 * @author Rohan Pawar
 */
public class ProjectModelQueries {
	
	/** The Constant GET_PROJECT_FROM_ID. */
	private static final String GET_PROJECT_FROM_ID = "SELECT * FROM PROJECTS WHERE PROJECT_ID=";
	
	/** The Constant GET_ALL_PROJECTS. */
	private static final String GET_ALL_PROJECTS = "SELECT * FROM PROJECTS";
	
	/**
	 * Gets the gets the all projects.
	 *
	 * @return the gets the all projects
	 */
	public static String getGetAllProjects() {
		return GET_ALL_PROJECTS;
	}

	/**
	 * Instantiates a new project model queries.
	 */
	private ProjectModelQueries() {
		
	}

	/**
	 * Gets the gets the project from id.
	 *
	 * @return the gets the project from id
	 */
	public static String getGetProjectFromId() {
		return GET_PROJECT_FROM_ID;
	}
	
}
