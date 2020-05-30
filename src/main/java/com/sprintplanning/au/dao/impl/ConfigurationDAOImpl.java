package com.sprintplanning.au.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.constants.ConfigurationModelConstants;
import com.sprintplanning.au.dao.ConfigurationDAO;
import com.sprintplanning.au.model.Configuration;
import com.sprintplanning.au.queries.ConfigurationModelQueries;
import com.sprintplanning.au.row_mapper.RowmapperConfiguration;

/**
 * The Class ConfigurationDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Repository
public class ConfigurationDAOImpl implements ConfigurationDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new configuration DAO impl.
	 */
	public ConfigurationDAOImpl() {

	}

	/**
	 * Instantiates a new configuration DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public ConfigurationDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Delete configuration.
	 *
	 * @param configurationId the configuration id
	 */
	@Override
	public void deleteConfiguration(String configurationId) {
		try {
			String deleteConfigQuery = ConfigurationModelQueries.getDeleteConfiguration() + "'" + configurationId + "'";
			jdbcTemplate.update(deleteConfigQuery);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}

	/**
	 * Save configuration.
	 *
	 * @param configuration the configuration
	 */
	@Override
	public void saveConfiguration(Configuration configuration) {
		try {
			String addConfigQuery = ConfigurationModelQueries.getAddConfiguration();
			jdbcTemplate.update(addConfigQuery, configuration.getSprintId(), configuration.getSprintDays());
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}

	/**
	 * Gets the configuration.
	 *
	 * @param configurationId the configuration id
	 * @return the configuration
	 */
	@Override
	public Configuration getConfiguration() {
		try {
			String getConfigurationDetails = ConfigurationModelQueries.getGetConfiuration();
			return jdbcTemplate.query(getConfigurationDetails, (ResultSet rs) -> {
				if (rs.next()) {
					Configuration configuration = new Configuration();

					configuration.setSprintId(rs.getString(ConfigurationModelConstants.getSprintId()));
					configuration.setSprintDays(rs.getInt(ConfigurationModelConstants.getSprintDays()));

					return configuration;
				}
				return new Configuration();
			});
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new Configuration();
	}

	/**
	 * List.
	 *
	 * @return the list
	 */
	@Override
	public List<Configuration> getAllConfigurations() {
		try {
			String getAllConfigurationDetails = ConfigurationModelQueries.getGetAllConfiguration();
			return jdbcTemplate.query(getAllConfigurationDetails, RowmapperConfiguration.configurationRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}
}
