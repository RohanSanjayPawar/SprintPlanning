package com.sprintplanning.au.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.UserProjectDAO;
import com.sprintplanning.au.model.UserModel;
import com.sprintplanning.au.queries.UserProjectModelQueries;
import com.sprintplanning.au.row_mapper.RowmapperUserProject;

/**
 * The Class UserProjectDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Repository
public class UserProjectDAOImpl implements UserProjectDAO{
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new user project DAO impl.
	 */
	public UserProjectDAOImpl() {
		
	}

	/**
	 * Instantiates a new user project DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public UserProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Gets the all users in project.
	 *
	 * @param userModel the user model
	 * @param projectModel the project model
	 * @return the all users in project
	 */
	@Override
	public List<UserModel> getAllUsersInProject(String projectId) {
		// UserProjectModelQueries
		try {
		String getAllUsers = UserProjectModelQueries.getUserProjectPoolQuery()+projectId;
		return jdbcTemplate.query(getAllUsers, RowmapperUserProject.UserProjectRowMapperLambda);
		} catch(Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

}
