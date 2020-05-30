package com.sprintplanning.au.service;

import javax.sql.DataSource;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class EnvironmentService implements EnvironmentAware{
	/** The env. */
	public static Environment env;

	/**
	 * Sets the environment.
	 *
	 * @param environment the new environment
	 */
	@Override
	public void setEnvironment(Environment environment) {
		EnvironmentService.env = environment;
	}
	
	/**
	 * Gets the data source (MySQL connection).
	 *
	 * @return the data source
	 */
	public static DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	} 
}
