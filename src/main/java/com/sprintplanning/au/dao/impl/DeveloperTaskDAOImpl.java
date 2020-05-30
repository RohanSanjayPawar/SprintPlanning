package com.sprintplanning.au.dao.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.DeveloperTaskDAO;
import com.sprintplanning.au.model.DeveloperTask;
import com.sprintplanning.au.queries.DeveloperTaskModelQueries;

/**
 * The Class DeveloperTaskDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Repository
public class DeveloperTaskDAOImpl implements DeveloperTaskDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new developer task DAO impl.
	 */
	public DeveloperTaskDAOImpl() {

	}

	/**
	 * Instantiates a new developer task DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public DeveloperTaskDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Save developer task.
	 *
	 * @param developerTask the developer task
	 */
	@Override
	public void saveDeveloperTask(DeveloperTask developerTask) {
		try {
			String addDevTaskQuery = DeveloperTaskModelQueries.getAddDeveloperTask();
			jdbcTemplate.update(addDevTaskQuery, developerTask.getDeveloperTaskId(), developerTask.getUserId(),
					developerTask.getTaskId(), developerTask.getEstimatedHours(), developerTask.getSprintId());
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}

		try {
			String updateTaskDates = DeveloperTaskModelQueries.getSetDatesForTask();
			jdbcTemplate.update(updateTaskDates, developerTask.getStartDate(), developerTask.getEndDate(),
					developerTask.getTaskId());
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}

}
