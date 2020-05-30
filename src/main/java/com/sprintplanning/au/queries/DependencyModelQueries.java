package com.sprintplanning.au.queries;

/**
 * The Class DependencyModelQueries.
 * 
 * @author Rohan Pawar
 */
public class DependencyModelQueries {
	
	/** The Constant GET_ALL_DEPENDENCIES. */
	private static final String GET_ALL_DEPENDENCIES = "SELECT d.TASK_ID, d.DEPENDENCY_ID FROM DEPENDENCIES d JOIN TASKS t ON t.TASK_ID = d.TASK_ID WHERE t.PROJECT_ID=";

	/**
	 * Gets the gets the all dependencies.
	 *
	 * @return the gets the all dependencies
	 */
	public static String getGetAllDependencies() {
		return GET_ALL_DEPENDENCIES;
	}
	
	/**
	 * Instantiates a new dependency model queries.
	 */
	private DependencyModelQueries() {
		
	}
}
