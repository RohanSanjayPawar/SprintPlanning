package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.ProjectModelConstants;
import com.sprintplanning.au.model.ProjectModel;
import com.sprintplanning.au.model.enums.WorkStatus;

/**
 * The Class RowmapperProject.
 * 
 * @author Rohan Pawar
 */
public class RowmapperProject {
	
	/**
	 * Instantiates a new rowmapper project.
	 */
	private RowmapperProject() {

	}
	
	/** The Constant projectRowMapperLambda. */
	public static final RowMapper<ProjectModel> projectRowMapperLambda = (rs, rownum) -> {
		ProjectModel projectModel = new ProjectModel();
		projectModel.setId(rs.getString(ProjectModelConstants.getProjectId()));
		projectModel.setName(rs.getString(ProjectModelConstants.getProjectName()));
		projectModel.setDescription(rs.getString(ProjectModelConstants.getProjectDescription()));
		projectModel.setStartDate(rs.getDate(ProjectModelConstants.getStartDate()));
		projectModel.setEstimatedEndDate(rs.getDate(ProjectModelConstants.getPredictedEndDate()));
		projectModel.setActualEndDate(rs.getDate(ProjectModelConstants.getActualEndDate()));
		switch(rs.getString(ProjectModelConstants.getProjectStatus())) {
			case "YET_TO_START":
				projectModel.setStatus(WorkStatus.YET_TO_START);
				break;
			case "STARTED":
				projectModel.setStatus(WorkStatus.STARTED);
				break;
			case "WORK_IN_PROGRESS":
				projectModel.setStatus(WorkStatus.WORK_IN_PROGRESS);
				break;
			case "ON_HOLD":
				projectModel.setStatus(WorkStatus.ON_HOLD);
				break;
			case "COMPLETED":
				projectModel.setStatus(WorkStatus.COMPLETED);
				break;
			default:
				projectModel.setStatus(WorkStatus.YET_TO_START);
				break;
		}
		return projectModel;
	};

}
