package com.sprintplanning.au.queries;

/**
 * The Class ConfigurationModelQueries.
 * 
 * @author Rohan Pawar
 */
public class ConfigurationModelQueries {

	/** The Constant DELETE_CONFIGURATION. */
	private static final String DELETE_CONFIGURATION = "UPDATE CONFIGURATIONS SET DELETED = 1 WHERE SPRINT_ID =";

	/** The Constant ADD_CONFIGURATION. */
	private static final String ADD_CONFIGURATION = "INSERT INTO CONFIGURATIONS(SPRINT_ID, SPRINT_DAYS) VALUES(?, ?)";

	/** The Constant GET_CONFIURATION. */
	private static final String GET_CONFIURATION = "SELECT * FROM CONFIGURATIONS c ORDER BY c.SPRINT_ID DESC LIMIT 1;";

	/** The Constant GET_ALL_CONFIGURATION. */
	private static final String GET_ALL_CONFIGURATION = "SELECT * FROM CONFIGURATIONS WHERE DELETED = 0";
	
	/**
	 * Gets the gets the confiuration.
	 *
	 * @return the gets the confiuration
	 */
	public static String getGetConfiuration() {
		return GET_CONFIURATION;
	}

	/**
	 * Gets the gets the all configuration.
	 *
	 * @return the gets the all configuration
	 */
	public static String getGetAllConfiguration() {
		return GET_ALL_CONFIGURATION;
	}

	/**
	 * Gets the adds the configuration.
	 *
	 * @return the adds the configuration
	 */
	public static String getAddConfiguration() {
		return ADD_CONFIGURATION;
	}

	/**
	 * Gets the delete configuration.
	 *
	 * @return the delete configuration
	 */
	public static String getDeleteConfiguration() {
		return DELETE_CONFIGURATION;
	}

	/**
	 * Instantiates a new configuration model queries.
	 */
	private ConfigurationModelQueries() {

	}
}
