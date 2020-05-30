package com.sprintplanning.au.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.Sprint;

/**
 * The Interface SprintDAO.

 * 
 * @author Gowsalya SG

 */
@Repository
public interface SprintDAO {

	/**
	 * Save sprint.
	 *
	 * @param sprint the sprint
	 */
	public void saveSprint(Sprint sprint);

	/**
	 * Gets the sprint.
	 *
	 * @param sprintId the sprint id
	 * @return the sprint
	 */
	public Sprint getSprint(String sprintId);

	/**
	 * Gets the all sprint.
	 *
	 * @return the all sprint
	 */
	public List<Sprint> getAllSprint();
}
