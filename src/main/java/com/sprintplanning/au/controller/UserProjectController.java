package com.sprintplanning.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.model.UserModel;
import com.sprintplanning.au.service.DBConfigService;

/**
 * The Class UserProjectController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/user-project")
@CrossOrigin
public class UserProjectController {
	
	/** The db configuration service. */
	@Autowired
	DBConfigService dbConfigurationService;
	
	/**
	 * Preset message.
	 *
	 * @return the list
	 */
	@GetMapping("/{id}")
	public List<UserModel> getUsersFromProjectId(@PathVariable("id") String projectId) {
		return dbConfigurationService.getUserProjectDAO().getAllUsersInProject(projectId);
	}
}
