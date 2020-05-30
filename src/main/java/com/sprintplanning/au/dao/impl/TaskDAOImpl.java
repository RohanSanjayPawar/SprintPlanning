package com.sprintplanning.au.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.TaskDAO;
import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.queries.TaskModelQueries;
import com.sprintplanning.au.row_mapper.RowmapperTask;

/**
 * The Class TaskDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Repository
public class TaskDAOImpl implements TaskDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new task DAO impl.
	 */
	public TaskDAOImpl() {

	}

	/**
	 * Instantiates a new task DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public TaskDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Gets the all tasks.
	 *
	 * @return the all tasks
	 */
	@Override
	public List<Task> getAllTasks() {
		try {
			String getAllTasks = TaskModelQueries.getGetAllTasks();
			return jdbcTemplate.query(getAllTasks, RowmapperTask.taskRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

	/**
	 * Gets the all tasks for project.
	 *
	 * @param projectId the project id
	 * @return the all tasks for project
	 */
	@Override
	public List<Task> getAllTasksForProject(String projectId) {
		try {
			String getAllTasksForProjectId = TaskModelQueries.getGetAllTasksForProjects() + projectId;
			return jdbcTemplate.query(getAllTasksForProjectId, RowmapperTask.taskRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

}
