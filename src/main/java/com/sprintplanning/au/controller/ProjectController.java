package com.sprintplanning.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.service.ProjectModelService;

/**
 * The Class ProjectController.
 * 
 * @author Gowsalya SG
 */
@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

	/** The project model service. */
	@Autowired
	ProjectModelService projectModelService;

	/**
	 * Preset message.
	 *
	 * @return the list
	 */
	@GetMapping("")
	public List<ProjectModel> presetMessage() {
		return projectModelService.getProjectModelDAO().getAllProjects();
	}

	/**
	 * Gets the project model by id.
	 *
	 * @param projectModelId the project model id
	 * @return the project model by id
	 */
	@GetMapping("/{id}")
	public ProjectModel getProjectModelById(@PathVariable("id") String projectModelId) {
		return projectModelService.getProjectModelDAO().getProjectFromId(projectModelId);
	}

}
