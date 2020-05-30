package com.sprintplanning.au.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.model.Dependency;
import com.sprintplanning.au.service.DependencyService;



/**
 * The Class DependencyController.
 * 
 * @author Gowsalya SG
 */
@RestController
@RequestMapping("/api/dependency")
@CrossOrigin
public class DependencyController {

	/* The dependency service. */
	@Autowired
	DependencyService dependencyService;
	
	/**
	 * Gets the all dependency.
	 *
	 * @return the all dependency
	 */
	@GetMapping("/{id}")
	public List<Dependency> getAllDependency(@PathVariable("id") String projectId) {
		return dependencyService.getDependencyDAO().getAllDependenciesMapping(projectId);
	}
}
