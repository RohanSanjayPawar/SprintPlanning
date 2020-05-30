package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.Configuration;

/**
 * The Interface ConfigurationDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface ConfigurationDAO {
	
	/**
	 * Save or update.
	 *
	 * @param configuration the configuration
	 * @return true, if successful
	 */
	public void saveConfiguration(Configuration configuration);

	/**
	 * Delete a configuration.
	 *
	 * @param configurationId the Configuration ID for a sprint
	 */
	public void deleteConfiguration(String configurationId);

	/**
	 * Gets the Configuration.
	 *
	 * @param configurationId the Configuration ID for a sprint
	 * @return the configuration
	 */
	public Configuration getConfiguration();

	/**
	 * List.
	 *
	 * @return the list
	 */
	public List<Configuration> getAllConfigurations();
}
