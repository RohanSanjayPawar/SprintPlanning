package com.sprintplanning.au.queries;

/**
 * The Class DeveloperLeavesModelQueries.
 * 
 * @author Rohan Pawar
 */
public class DeveloperLeavesModelQueries {

	/** The Constant ADD_DEVELOPER_LEAVE. */
	private static final String ADD_DEVELOPER_LEAVE = "INSERT INTO DEVELOPER_LEAVES(USER_ID, START_DATE, END_DATE, REASON) VALUES(?, ?, ?, ?)";

	/** The Constant GET_ALL_DEVELOPER_LEAVE. */
	private static final String GET_ALL_DEVELOPER_LEAVE = "SELECT * FROM DEVELOPER_LEAVES WHERE DELETED = 0";

	/** The Constant GET_ALL_DEVELOPER_LEAVE_FOR_USER. */
	private static final String GET_ALL_DEVELOPER_LEAVE_FOR_USER = "SELECT * FROM DEVELOPER_LEAVES WHERE DELETED = 0 AND USER_ID=";

	/**
	 * Gets the gets the all developer leave for user.
	 *
	 * @return the gets the all developer leave for user
	 */
	public static String getGetAllDeveloperLeaveForUser() {
		return GET_ALL_DEVELOPER_LEAVE_FOR_USER;
	}

	/**
	 * Gets the gets the all developer leave.
	 *
	 * @return the gets the all developer leave
	 */
	public static String getGetAllDeveloperLeave() {
		return GET_ALL_DEVELOPER_LEAVE;
	}

	/**
	 * Gets the adds the developer leave.
	 *
	 * @return the adds the developer leave
	 */
	public static String getAddDeveloperLeave() {
		return ADD_DEVELOPER_LEAVE;
	}

	/**
	 * Instantiates a new developer leaves model queries.
	 */
	private DeveloperLeavesModelQueries() {

	}
}
