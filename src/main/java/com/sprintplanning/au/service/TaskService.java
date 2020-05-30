package com.sprintplanning.au.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sprintplanning.au.dao.TaskDAO;
import com.sprintplanning.au.dao.impl.TaskDAOImpl;

/**
 * The Class TaskService.
 * 
 * @author Gowsalya SG
 */
@Configuration
@PropertySource("classpath:application.properties")
public class TaskService extends EnvironmentService{
	/**
	 * Gets the task DAO.
	 *
	 * @return the task DAO
	 */
	@Bean
	public TaskDAO getTaskDAO() {
        return new TaskDAOImpl(getDataSource());
    }
}
