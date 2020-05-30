package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.UserDetailsModelConstants;
import com.sprintplanning.au.model.UserModel;
import com.sprintplanning.au.model.enums.UserRole;

/**
 * The Class RowmapperUserProject.
 * 
 * @author Rohan Pawar
 */
public class RowmapperUserProject {
	
	/**
	 * Instantiates a new rowmapper user project.
	 */
	private RowmapperUserProject() {
		
	}
	
	/** The Constant UserProjectRowMapperLambda. */
	public static final RowMapper<UserModel> UserProjectRowMapperLambda = (rs, rownum) -> {
		UserModel userModel = new UserModel();
		userModel.setId(rs.getString(UserDetailsModelConstants.getUserId()));
		userModel.setUsername(rs.getString(UserDetailsModelConstants.getUserName()));
		userModel.setDisplayName(rs.getString(UserDetailsModelConstants.getDisplayName()));
		userModel.setEmail(rs.getString(UserDetailsModelConstants.getUserEmail()));
		userModel.setEfficiency(rs.getDouble(UserDetailsModelConstants.getUserEfficiency()));
		if(rs.getString(UserDetailsModelConstants.getUserRole()).equals("ADMIN"))
			userModel.setRole(UserRole.ADMIN);
		else
			userModel.setRole(UserRole.DEVELOPER);
		return userModel;
	};

}
