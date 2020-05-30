
package com.sprintplanning.au.filters;

import java.util.List;

import com.sprintplanning.au.model.Dependency;
import com.sprintplanning.au.model.DeveloperLeaves;
import com.sprintplanning.au.model.GlobalHoliday;
import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.model.UserModel;
import com.sprintplanning.au.service.DBConfigService;
import com.sprintplanning.au.service.DependencyService;
import com.sprintplanning.au.service.GlobalHolidayService;
import com.sprintplanning.au.service.ProjectModelService;

/**
 * The Class FetchFilters.
 * 
 * @author Rohan Pawar
 */
public class FetchFilters {
	/**
	 * Filter users.
	 *
	 * @param projectId the project id
	 * @return the list
	 */
	public List<UserModel> filterUsers(String projectId) {
		DBConfigService dbConfigurationService = new DBConfigService();
		return dbConfigurationService.getUserProjectDAO().getAllUsersInProject(projectId);
	}
	
	/**
	 * Gets the all holidays.
	 *
	 * @return the all holidays
	 */
	public List<GlobalHoliday> getAllHolidays() {
		GlobalHolidayService globalHolidayService = new GlobalHolidayService();
		return globalHolidayService.getGlobalHolidayDAO().getAllGlobalHoliday();
	}
	
	/**
	 * Gets the all leaves for developer.
	 *
	 * @param userId the user id
	 * @return the all leaves for developer
	 */
	public List<DeveloperLeaves> getAllLeavesForDeveloper(String userId) {
		DBConfigService dbConfigurationService = new DBConfigService();
		return dbConfigurationService.getLeavesDAO().getAllDeveloperLeaves(userId);
	}
	
	/**
	 * Gets the project by id.
	 *
	 * @param projectId the project id
	 * @return the project by id
	 */
	public ProjectModel getProjectById(String projectId) {
		ProjectModelService projectService = new ProjectModelService();
		return projectService.getProjectModelDAO().getProjectFromId(projectId);
	}
	
	/**
	 * Gets the all dependencies.
	 *
	 * @param projectId the project id
	 * @return the all dependencies
	 */
	public List<Dependency> getAllDependencies(String projectId) {
		DependencyService dependencyService = new DependencyService();
		return dependencyService.getDependencyDAO().getAllDependenciesMapping(projectId);
	}
}
