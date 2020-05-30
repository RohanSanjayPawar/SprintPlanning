package com.sprintplanning.au.queries;

/**
 * The Class ProjectSprintQueries.
 * 
 * @author Rohan Pawar
 */
public class ProjectSprintQueries {
	
	/** The Constant GET_PROJECT_SPRINT. */
	private static final String GET_PROJECT_SPRINT = "SELECT *, WEEK(t.TASK_START_DATE), WEEK(t.TASK_END_DATE) FROM developer_tasks d JOIN tasks t ON d.TASK_ID = t.TASK_ID JOIN SPRINTS s ON s.SPRINT_ID = d.SPRINT_ID WHERE t.PROJECT_ID=";

	/**
	 * Gets the gets the project sprint.
	 *
	 * @return the gets the project sprint
	 */
	public static String getGetProjectSprint() {
		return GET_PROJECT_SPRINT;
	}
	
	/**
	 * Instantiates a new project sprint queries.
	 */
	private ProjectSprintQueries() {
		
	}
	
}
