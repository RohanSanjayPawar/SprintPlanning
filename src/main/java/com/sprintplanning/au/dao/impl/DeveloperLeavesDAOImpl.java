package com.sprintplanning.au.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.DeveloperLeavesDAO;
import com.sprintplanning.au.model.DeveloperLeaves;
import com.sprintplanning.au.queries.DeveloperLeavesModelQueries;
import com.sprintplanning.au.row_mapper.RowmapperLeaves;

/**
 * The Class LeavesDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Repository
public class DeveloperLeavesDAOImpl implements DeveloperLeavesDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new configuration DAO impl.
	 */
	public DeveloperLeavesDAOImpl() {

	}

	/**
	 * Instantiates a new leaves DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public DeveloperLeavesDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Save developer leave.
	 *
	 * @param leaves the leaves
	 */
	@Override
	public void saveDeveloperLeave(DeveloperLeaves leaves) {
		try {
			String addLeavesQuery = DeveloperLeavesModelQueries.getAddDeveloperLeave();
			jdbcTemplate.update(addLeavesQuery, leaves.getUserId(), leaves.getStartDayOfLeave(),
					leaves.getEndDayOfLeave(), leaves.getReasonForLeave());
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}

	/**
	 * Gets the all developer leaves.
	 *
	 * @return the all developer leaves
	 */
	@Override
	public List<DeveloperLeaves> getAllDeveloperLeaves(String userId) {
		try {
			String getAllLeaveDetails = DeveloperLeavesModelQueries.getGetAllDeveloperLeaveForUser() + userId;
			return jdbcTemplate.query(getAllLeaveDetails, RowmapperLeaves.leavesnRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

	@Override
	public List<DeveloperLeaves> getAllLeaves() {
		try {
			String getAllLeaveDetails = DeveloperLeavesModelQueries.getGetAllDeveloperLeave();
			return jdbcTemplate.query(getAllLeaveDetails, RowmapperLeaves.leavesnRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

}
