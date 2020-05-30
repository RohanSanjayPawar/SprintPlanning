package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.ConfigurationModelConstants;
import com.sprintplanning.au.model.Configuration;

/**
 * The Class RowmapperConfiguration.
 * 
 * @author Rohan Pawar
 */
public class RowmapperConfiguration {
	
	/**
	 * Instantiates a new rowmapper configuration.
	 */
	private RowmapperConfiguration() {
		
	}
	
	/** The Constant configurationRowMapperLambda. */
	public static final RowMapper<Configuration> configurationRowMapperLambda = (rs, rownum) -> {
		Configuration configuration = new Configuration();
		configuration.setSprintId(rs.getString(ConfigurationModelConstants.getSprintId()));
		configuration.setSprintDays(rs.getInt(ConfigurationModelConstants.getSprintDays()));
		return configuration;
	};
	

	

	
}