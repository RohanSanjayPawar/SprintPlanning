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

import com.sprintplanning.au.model.Configuration;
import com.sprintplanning.au.service.DBConfigService;

/**
 * The Class ConfigurationController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/configuration")
@CrossOrigin
public class ConfigurationController {
	
	/** The configuration service. */
	@Autowired
	DBConfigService dbConfigurationService;
	
	@GetMapping("")
	public List<Configuration> presetMessage() {
		return dbConfigurationService.getConfigurationDAO().getAllConfigurations();
	}
	
	/**
	 * Gets the confiuration by id.
	 *
	 * @param configurationId the configuration id
	 * @return the confiuration by id
	 */
	@GetMapping("/{id}")
	public Configuration getConfiurationById() {
		return dbConfigurationService.getConfigurationDAO().getConfiguration();
	}
	
	/**
	 * Adds the configuration.
	 *
	 * @param configuration the configuration
	 */
	@PostMapping(path="/add", consumes = "application/json")
	public void addConfiguration(@RequestBody Configuration configuration) {
		dbConfigurationService.getConfigurationDAO().saveConfiguration(configuration);
	}
	
	/**
	 * Delete configuration.
	 *
	 * @param configurationId the configuration id
	 */
	@PostMapping(path="/delete/{id}")
	public void deleteConfiguration(@PathVariable("id") String configurationId) {
		dbConfigurationService.getConfigurationDAO().deleteConfiguration(configurationId);
	}
	
}
