package com.sprintplanning.au.constants;

/**
 * The Class LeavesModelConstants.
 *
 * @author Rohan Pawar
 */
public class LeavesModelConstants {
	
	/** The Constant DEVELOPER_ID. */
	private static final String DEVELOPER_ID = "USER_ID";
	
	/** The Constant START_DATE_OF_LEAVE. */
	private static final String START_DATE_OF_LEAVE = "START_DATE";
	
	/** The Constant END_DATE_OF_LEAVE. */
	private static final String END_DATE_OF_LEAVE = "END_DATE";
	
	/** The Constant REASON_FOR_LEAVE. */
	private static final String REASON_FOR_LEAVE = "REASON";

	/**
	 * Gets the developer id.
	 *
	 * @return the developer id
	 */
	public static String getDeveloperId() {
		return DEVELOPER_ID;
	}

	/**
	 * Gets the start date of leave.
	 *
	 * @return the start date of leave
	 */
	public static String getStartDateOfLeave() {
		return START_DATE_OF_LEAVE;
	}

	/**
	 * Gets the end date of leave.
	 *
	 * @return the end date of leave
	 */
	public static String getEndDateOfLeave() {
		return END_DATE_OF_LEAVE;
	}

	/**
	 * Gets the reason for leave.
	 *
	 * @return the reason for leave
	 */
	public static String getReasonForLeave() {
		return REASON_FOR_LEAVE;
	}
	
	/**
	 * Instantiates a new leaves model constants.
	 */
	private LeavesModelConstants() {
		
	}
}
