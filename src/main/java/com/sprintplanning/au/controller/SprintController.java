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

import com.sprintplanning.au.model.Sprint;
import com.sprintplanning.au.service.SprintService;


/**
 * The Class SprintController.
 */
@RestController
@RequestMapping("/api/sprint")
@CrossOrigin
public class SprintController {
	
	/** The sprint service. */
	@Autowired
	SprintService sprintService;
	
	/**
	 * Preset message.
	 *
	 * @return the list
	 */
	@GetMapping("")
	public List<Sprint> presetMessage() {
		return sprintService.getSprintDAO().getAllSprint();
	}
	

	/**
	 * Gets the sprint by id.
	 *
	 * @param sprintId the sprint id
	 * @return the sprint by id
	 */
	@GetMapping("/{id}")
	public Sprint getSprintById(@PathVariable("id") String sprintId) {
		return sprintService.getSprintDAO().getSprint(sprintId);
	}
	

	/**
	 * Adds the Sprint.
	 *
	 * @param sprint the sprint
	 */
	@PostMapping(path="/add", consumes = "application/json")
	public void addSprint(@RequestBody Sprint sprint) {
		sprintService.getSprintDAO().saveSprint(sprint);
	}
	


}
