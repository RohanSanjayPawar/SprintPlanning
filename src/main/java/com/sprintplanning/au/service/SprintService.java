package com.sprintplanning.au.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sprintplanning.au.dao.ProjectSprintDAO;
import com.sprintplanning.au.dao.SprintDAO;
import com.sprintplanning.au.dao.impl.ProjectSprintDAOImpl;
import com.sprintplanning.au.dao.impl.SprintDAOImpl;

/**
 * The Class SprintService.
 * 
 * @author Gowsalya SG
 */
@Configuration
@PropertySource("classpath:application.properties")
public class SprintService extends EnvironmentService {
	/**
	 * Gets the sprint DAO.
	 *
	 * @return the sprint DAO
	 */
	@Bean
	public SprintDAO getSprintDAO() {
        return new SprintDAOImpl(getDataSource());
    }
	
	/**
	 * Gets the project sprint DAO.
	 *
	 * @return the project sprint DAO
	 */
	@Bean
	public ProjectSprintDAO getProjectSprintDAO() {
		return new ProjectSprintDAOImpl(getDataSource());
	}
}

