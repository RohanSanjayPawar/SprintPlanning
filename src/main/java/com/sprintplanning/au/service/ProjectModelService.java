package com.sprintplanning.au.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sprintplanning.au.dao.ProjectDAO;
import com.sprintplanning.au.dao.impl.ProjectDAOImpl;

/**
 * The Class ProjectModelService.
 * 
 * @author Rohan Pawar
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ProjectModelService extends EnvironmentService{
	/**
	 * Gets the project model DAO.
	 *
	 * @return the project model DAO
	 */
	@Bean
	public ProjectDAO getProjectModelDAO() {
        return new ProjectDAOImpl(getDataSource());
    }
	
}
