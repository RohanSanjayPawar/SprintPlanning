package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.DependencyModelConstants;
import com.sprintplanning.au.model.Dependency;

/**
 * The Class RowmapperDependency.
 * 
 * @author Rohan Pawar
 */
public class RowmapperDependency {
	
	/**
	 * Instantiates a new rowmapper dependency.
	 */
	private RowmapperDependency() {
		
	}
	
	/** The Constant dependencyRowMapperLambda. */
	public static final RowMapper<Dependency> dependencyRowMapperLambda = (rs, rownum) -> {
		Dependency dependency = new Dependency();
		dependency.setTaskId(rs.getString(DependencyModelConstants.getTaskId()));
		dependency.setDependencyId(rs.getString(DependencyModelConstants.getDependencyId()));
		return dependency;
	};
}
