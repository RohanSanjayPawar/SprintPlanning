package com.sprintplanning.au.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sprintplanning.au.dao.DependencyDAO;
import com.sprintplanning.au.dao.impl.DependencyDAOImpl;

/**
 * The Class SprintService.
 * 
 * @author Gowsalya SG
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DependencyService extends EnvironmentService{

	/**
	 * Gets the sprint DAO.
	 *
	 * @return the sprint DAO
	 */
	@Bean
	public DependencyDAO getDependencyDAO() {
        return new DependencyDAOImpl(getDataSource());
    }
	
}
