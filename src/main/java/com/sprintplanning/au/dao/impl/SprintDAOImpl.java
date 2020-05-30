package com.sprintplanning.au.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.constants.SprintModelConstants;
import com.sprintplanning.au.dao.SprintDAO;
import com.sprintplanning.au.model.Sprint;
import com.sprintplanning.au.queries.SprintModelQueries;
import com.sprintplanning.au.row_mapper.RowMapperSprint;

/**
 * The Class SprintDAOImpl.
 * 
 * @author Gowsalya SG
 */
@Repository
public class SprintDAOImpl implements SprintDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new sprint DAO impl.
	 */
	public SprintDAOImpl() {

	}

	/**
	 * Instantiates a new sprint DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public SprintDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Save sprint.
	 *
	 * @param sprint the sprint
	 */
	/*@Override
	public void saveSprint(Sprint sprint) {
		DBConfigService developerTaskDAOImpl = new DBConfigService();
		try {
			for (DeveloperTask developerTask : sprint.getSprintTasks()) {
				developerTaskDAOImpl.getDevloperTaskDAO().saveDeveloperTask(developerTask);
			}

			String addSprintQuery = SprintModelQueries.getAddSprint();
			jdbcTemplate.update(addSprintQuery, sprint.getId(), sprint.getName(), sprint.getProjectId(),
					sprint.getGeneratedDate(), sprint.getSprintDays());
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
<<<<<<< HEAD:SprintPlanningBackend/src/main/java/com/sprintplanning/au/dao/impl/SprintDAOImpl.java
		
		String addSprintQuery = SprintModelQueries.getAddSprint();
		jdbcTemplate.update(addSprintQuery, sprint.getId(), sprint.getName(), sprint.getProjectId(),
				sprint.getGeneratedDate(), sprint.getSprintDays());
	}*/
	/**
	 * Gets the sprint.
	 *
	 * @param sprintId the sprint id
	 * @return the sprint
	 */
	@Override
	public Sprint getSprint(String sprintId) {
		try {
		String getSprintDetails = SprintModelQueries.getGetSprint() + sprintId;
		return jdbcTemplate.query(getSprintDetails, (ResultSet rs) -> {
			if (rs.next()) {
				Sprint sprint = new Sprint();

				sprint.setId(rs.getString(SprintModelConstants.getSprintId()));
				sprint.setName(rs.getString(SprintModelConstants.getSprintName()));
				sprint.setProjectId(rs.getString(SprintModelConstants.getProjectId()));
				sprint.setGeneratedDate(rs.getDate(SprintModelConstants.getGeneratedDate()));
				sprint.setSprintDays(rs.getInt(SprintModelConstants.getSprintDays()));

				return sprint;
			}
			return new Sprint();
		});
		} catch(Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		
		return new Sprint();
	}

	/**
	 * Gets the all sprint.
	 *
	 * @return the all sprint
	 */
	@Override
	public List<Sprint> getAllSprint() {
		try {
		String getAllSprintDetails = SprintModelQueries.getGetAllSprint();
		return jdbcTemplate.query(getAllSprintDetails, RowMapperSprint.SprintRowMapperLambda);
		} catch(Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

	@Override
	public void saveSprint(Sprint sprint) {
		// TODO Auto-generated method stub
		
	}
}
