package com.sprintplanning.au.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sprintplanning.au.dao.ConfigurationDAO;
import com.sprintplanning.au.dao.DeveloperLeavesDAO;
import com.sprintplanning.au.dao.DeveloperTaskDAO;
import com.sprintplanning.au.dao.UserProjectDAO;
import com.sprintplanning.au.dao.impl.ConfigurationDAOImpl;
import com.sprintplanning.au.dao.impl.DeveloperLeavesDAOImpl;
import com.sprintplanning.au.dao.impl.DeveloperTaskDAOImpl;
import com.sprintplanning.au.dao.impl.UserProjectDAOImpl;

/**
 * The Class ConfigurationService.
 * 
 * @author Rohan Pawar
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DBConfigService extends EnvironmentService{
	
	/**
	 * Gets the configuration DAO.
	 *
	 * @return the configuration DAO
	 */
	@Bean
	public ConfigurationDAO getConfigurationDAO() {
        return new ConfigurationDAOImpl(getDataSource());
    }
	
	/**
	 * Gets the leaves DAO.
	 *
	 * @return the leaves DAO
	 */
	@Bean
	public DeveloperLeavesDAO getLeavesDAO() {
		return new DeveloperLeavesDAOImpl(getDataSource());
	}
	
	/**
	 * Gets the devloper task DAO.
	 *
	 * @return the devloper task DAO
	 */
	@Bean
	public DeveloperTaskDAO getDevloperTaskDAO() {
		return new DeveloperTaskDAOImpl(getDataSource());
	}
	
	/**
	 * Gets the user project DAO.
	 *
	 * @return the user project DAO
	 */
	@Bean
	public UserProjectDAO getUserProjectDAO() {
		return new UserProjectDAOImpl(getDataSource());
	}
	
}
