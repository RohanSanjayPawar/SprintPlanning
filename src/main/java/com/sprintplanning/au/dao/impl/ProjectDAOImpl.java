package com.sprintplanning.au.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.ProjectDAO;
import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.queries.ProjectModelQueries;
import com.sprintplanning.au.row_mapper.RowmapperProject;

/**
 * The Class ProjectDAOImpl.
 * 
 * @author Gowsalya SG
 */
@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new project DAO impl.
	 */
	public ProjectDAOImpl() {

	}

	/**
	 * Instantiates a new project DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Gets the all projects.
	 *
	 * @return the all projects
	 */
	@Override
	public List<ProjectModel> getAllProjects() {
		try {
			String getAllProjects = ProjectModelQueries.getGetAllProjects();
			return jdbcTemplate.query(getAllProjects, RowmapperProject.projectRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}

	/**
	 * Gets the project from id.
	 *
	 * @param projectId the project id
	 * @return the project from id
	 */
	@Override
	public ProjectModel getProjectFromId(String projectId) {
		try {
			String getProjectById = ProjectModelQueries.getGetProjectFromId() + projectId;
			return jdbcTemplate.queryForObject(getProjectById, RowmapperProject.projectRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ProjectModel();
	}

}
