package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.Task;

/**
 * The Interface TaskDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface TaskDAO {
	
	/**
	 * Gets the all tasks.
	 *
	 * @return the all tasks
	 */
	public List<Task> getAllTasks();
	
	/**
	 * Gets the all tasks for project.
	 *
	 * @param projectId the project id
	 * @return the all tasks for project
	 */
	public List<Task> getAllTasksForProject(String projectId);

}
