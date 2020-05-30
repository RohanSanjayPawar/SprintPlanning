package com.sprintplanning.au.queries;

/**
 * The Class UserLeavesModelQueries.
 * 
 * @author Rohan Pawar
 */
public class UserLeavesModelQueries {

	/** The Constant USER_LEAVES_QUERY. */
	private static final String USER_LEAVES_QUERY="SELECT * FORM DEVELOPER_LEAVES";
	
	/**
	 *
	 * getting the user leaves query
	 * 
	 * @return the user leaves query
	 */
	public static String getUserLeavesQuery() {
		return USER_LEAVES_QUERY;
	}
    
	/**	 
	 * Instantiaties the new user leaves query
	 */
    private UserLeavesModelQueries ()
    {
    	
    }
}
