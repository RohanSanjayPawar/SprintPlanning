package com.sprintplanning.au.queries;

/**
 * The Class GlobalHolidayModelQueries.
 * 
 * @author Gowsalya SG
 */
public class GlobalHolidayModelQueries {



	/** The Constant GET_ALL_GLOBALHOLIDAY. */
	private static final String GET_ALL_GLOBALHOLIDAY = "SELECT * FROM GLOBAL_HOLIDAYS WHERE DELETED = 0";

	
	/** The Constant ADD_GLOBALHOLIDAY. */
	private static final String ADD_GLOBALHOLIDAY= "INSERT INTO GLOBAL_HOLIDAYS( DATE_OF_HOLIDAY ,HOLIDAY_DESCRIPTION) VALUES(?, ?)";


	/** The Constant GET_GLOBALHOLIDAY. */
	private static final String GET_GLOBALHOLIDAY = "SELECT * FROM GLOBAL_HOLIDAYS WHERE DELETED = 0 AND DATE_OF_HOLIDAY=";

	/**
	 * Gets the gets the all globalholiday.
	 *
	 * @return the gets the all globalholiday
	 */
	public static String getGetAllGlobalholiday() {
		return GET_ALL_GLOBALHOLIDAY;
	}

	/**
	 * Gets the adds the globalholiday.
	 *
	 * @return the adds the globalholiday
	 */
	public static String getAddGlobalholiday() {
		return ADD_GLOBALHOLIDAY;
	}

	/**
	 * Gets the gets the globalholiday.
	 *
	 * @return the gets the globalholiday
	 */
	public static String getGetGlobalholiday() {
		return GET_GLOBALHOLIDAY;
	}

	
	/**
	 * Instantiates a new global holiday model queries.
	 */
	private GlobalHolidayModelQueries() {

	}

}
