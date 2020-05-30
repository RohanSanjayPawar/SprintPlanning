package com.sprintplanning.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.model.DeveloperLeaves;
import com.sprintplanning.au.service.DBConfigService;

/**
 * The Class DeveloperLeavesController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/leaves")
@CrossOrigin
public class DeveloperLeavesController {
	
	/** The db configuration service. */
	@Autowired
	DBConfigService dbConfigurationService;
	
	/**
	 * Preset message.
	 *
	 * @return the list
	 */
	@GetMapping("")
	public List<DeveloperLeaves> getAllLeaves() {
		return dbConfigurationService.getLeavesDAO().getAllLeaves();
	}
	
	/**
	 * Gets the all leaves for developer.
	 *
	 * @param userId the user id
	 * @return the all leaves for developer
	 */
	@GetMapping("/{id}")
	public List<DeveloperLeaves> getAllLeavesForDeveloper(@PathVariable("id") String userId) {
		return dbConfigurationService.getLeavesDAO().getAllDeveloperLeaves(userId);
	}
	
	/**
	 * Adds the leaves.
	 *
	 * @param developerLeaves the developer leaves
	 */
	@PostMapping(path="/add", consumes = "application/json")
	public void addLeaves(@RequestBody DeveloperLeaves developerLeaves) {
		dbConfigurationService.getLeavesDAO().saveDeveloperLeave(developerLeaves);
	}
}
