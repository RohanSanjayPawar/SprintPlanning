package com.sprintplanning.au.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sprintplanning.au.dao.GlobalHolidayDAO;
import com.sprintplanning.au.dao.impl.GlobalHolidayDAOImpl;


/**
 * The Class GlobalHolidayService.
 * 
 * @author Gowsalya SG
 */
@Configuration
@PropertySource("classpath:application.properties")
public class GlobalHolidayService extends EnvironmentService {
	/**
	 * Gets the global holiday DAO.
	 *
	 * @return the global holiday DAO
	 */
	@Bean
	public GlobalHolidayDAO getGlobalHolidayDAO() {
        return new GlobalHolidayDAOImpl(getDataSource());
    }
	
}

