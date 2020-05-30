package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.UserModel;

/**
 * The Interface UserProjectDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface UserProjectDAO {
	
	/**
	 * Gets the all users in project.
	 *
	 * @param userModel the user model
	 * @param projectModel the project model
	 * @return the all users in project
	 */
	public List<UserModel> getAllUsersInProject(String projectId);
	
}
