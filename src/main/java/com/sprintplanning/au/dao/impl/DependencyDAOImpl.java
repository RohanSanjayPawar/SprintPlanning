package com.sprintplanning.au.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.DependencyDAO;
import com.sprintplanning.au.model.Dependency;
import com.sprintplanning.au.queries.DependencyModelQueries;
import com.sprintplanning.au.row_mapper.RowmapperDependency;

/**
 * The Class DependencyDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Repository
public class DependencyDAOImpl implements DependencyDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Instantiates a new dependency DAO impl.
	 */
	public DependencyDAOImpl() {
		
	}
	
	/**
	 * Instantiates a new dependency DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public DependencyDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Gets the all dependencies mapping.
	 *
	 * @param projectId the project id
	 * @return the all dependencies mapping
	 */
	@Override
	public List<Dependency> getAllDependenciesMapping(String projectId) {
		try {
			String getAllDependency = DependencyModelQueries.getGetAllDependencies()+projectId;
			return jdbcTemplate.query(getAllDependency, RowmapperDependency.dependencyRowMapperLambda);
		} catch(Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

}
