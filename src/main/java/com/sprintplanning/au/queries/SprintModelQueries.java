package com.sprintplanning.au.queries;

/**
 * The Class SprintModelQueries.
 * 
 * @author Gowsalya SG
 */
public class SprintModelQueries {

	/** The Constant ADD_SPRINT. */
	private static final String ADD_SPRINT = "INSERT INTO SPRINTS(SPRINT_ID,SPRINT_NAME,PROJECT_ID,GENERATED_DATE,SPRINT_DAYS) VALUES(?,?,?,?,?)";

	/** The Constant GET_SPRINT. */
	private static final String GET_SPRINT = "SELECT * FROM SPRINTS WHERE DELETED = 0 AND SPRINT_ID=";

	/** The Constant GET_ALL_SPRINT. */
	private static final String GET_ALL_SPRINT = "SELECT * FROM SPRINTS WHERE DELETED = 0";

	/**
	 * Instantiates a new sprint model queries.
	 */
	private SprintModelQueries() {

	}

	/**
	 * Gets the adds the sprint.
	 *
	 * @return the adds the sprint
	 */
	public static String getAddSprint() {
		return ADD_SPRINT;
	}

	/**
	 * Gets the gets the sprint.
	 *
	 * @return the gets the sprint
	 */
	public static String getGetSprint() {
		return GET_SPRINT;
	}

	/**
	 * Gets the gets the all sprint.
	 *
	 * @return the gets the all sprint
	 */
	public static String getGetAllSprint() {
		return GET_ALL_SPRINT;
	}
}
