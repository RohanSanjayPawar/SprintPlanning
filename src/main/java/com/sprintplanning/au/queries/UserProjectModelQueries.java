package com.sprintplanning.au.queries;

/**
 * The Class UserProjectModelQueries.
 * 
 * @author Rohan Pawar
 */
public class UserProjectModelQueries {
	
	/** The Constant USER_PROJECT_POOL_QUERY. */
	private static final String USER_PROJECT_POOL_QUERY = "SELECT * FROM USERS u JOIN DEVELOPER_PROJECTS dp ON u.USER_ID = dp.USER_ID WHERE dp.PROJECT_ID=";

	/**
	 * Gets the user project pool query.
	 *
	 * @return the user project pool query
	 */
	public static String getUserProjectPoolQuery() {
		return USER_PROJECT_POOL_QUERY;
	}
	
	
	/**
	 * Instantiates a new user project model queries.
	 */
	private UserProjectModelQueries() {
		
	}

}
