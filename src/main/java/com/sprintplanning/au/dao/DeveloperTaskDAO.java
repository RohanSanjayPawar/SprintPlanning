package com.sprintplanning.au.dao;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.DeveloperTask;

/**
 * The Interface DeveloperTaskDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface DeveloperTaskDAO {
	
	/**
	 * Save developer task.
	 *
	 * @param developerTask the developer task
	 */
	public void saveDeveloperTask(DeveloperTask developerTask);
}
