package com.sprintplanning.au.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.service.TaskService;


@RestController
@RequestMapping("/api/task")
@CrossOrigin
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("")
	public List<Task> getAllTask() {
		return taskService.getTaskDAO().getAllTasks();
	}
	

	@GetMapping("/{id}")
	public List<Task> getTaskForProjectId(@PathVariable("id") String projectId) {
		return taskService.getTaskDAO().getAllTasksForProject(projectId);
	}


	
}
