package com.sprintplanning.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.model.DeveloperTask;
import com.sprintplanning.au.service.DBConfigService;

/**
 * The Class DeveloperTaskController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/dev-task")
@CrossOrigin
public class DeveloperTaskController {
	
	/** The db configuration service. */
	@Autowired
	DBConfigService dbConfigurationService;
	
	/**
	 * Adds the dev task.
	 *
	 * @param developerTask the developer task
	 */
	@PostMapping(path="/add", consumes = "application/json")
	public void addDevTask(@RequestBody DeveloperTask developerTask) {
		dbConfigurationService.getDevloperTaskDAO().saveDeveloperTask(developerTask);
	}
}
