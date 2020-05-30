package com.sprintplanning.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.SprintGenerator;
import com.sprintplanning.au.model.ProjectSprint;
import com.sprintplanning.au.model.Sprint;
import com.sprintplanning.au.model.SprintResponse;
import com.sprintplanning.au.service.SprintService;

@RestController
@RequestMapping("/api/ps")
@CrossOrigin
public class ProjectSprintController {
	
	SprintGenerator sprintGenerator =  new SprintGenerator();
	
	/** The sprint service. */
	@Autowired
	SprintService sprintService;
	
	@PostMapping(path="/add/{id}")
	public SprintResponse generateSprint(@PathVariable("id") String projectId) {
		SprintResponse sprintResponse = new SprintResponse();
		ProjectSprint projectSprint = sprintGenerator.generateSprint(projectId);
		if(projectSprint.getSprints() != null) {
			for(Sprint sprint: projectSprint.getSprints()) {
				sprintService.getSprintDAO().saveSprint(sprint);
			}
			sprintResponse.setMessage("SUCCESS");
		}
		else {
			sprintResponse.setMessage("FAILURE");
		}
		sprintResponse.setProjectSprint(projectSprint);
		return sprintResponse;
	}
	
	@GetMapping(path="/{id}")
	public SprintResponse getSprintResponse(@PathVariable("id") String projectId) {
		return sprintService.getProjectSprintDAO().getProjectSprintById(projectId);
	}
	
	@GetMapping(path="/weekly/{id}")
	public SprintResponse getSprintResponseWeekly(@PathVariable("id") String projectId) {
		return sprintService.getProjectSprintDAO().getProjectSprintWeekly(projectId);
	}
	
}
