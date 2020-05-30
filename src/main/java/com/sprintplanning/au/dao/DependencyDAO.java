package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.Dependency;

/**
 * The Interface DependencyDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface DependencyDAO {
	
	/**
	 * Gets the all dependencies mapping.
	 *
	 * @return the all dependencies mapping
	 */
	public List<Dependency> getAllDependenciesMapping(String projectId);
	
}
