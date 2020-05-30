package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.DeveloperLeaves;

/**
 * The Interface LeavesDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface DeveloperLeavesDAO {
	
	/**
	 * Save developer leave.
	 *
	 * @param leaves the leaves
	 */
	public void saveDeveloperLeave(DeveloperLeaves leaves);
	
	/**
	 * Gets the all developer leaves.
	 *
	 * @param userId the user id
	 * @return the all developer leaves
	 */
	public List<DeveloperLeaves> getAllDeveloperLeaves(String userId);
	
	/**
	 * Gets the all leaves.
	 *
	 * @return the all leaves
	 */
	public List<DeveloperLeaves> getAllLeaves();
	
}
