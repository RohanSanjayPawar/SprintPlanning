package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.SprintModelConstants;
import com.sprintplanning.au.model.Sprint;

/**
 * The Class RowMapperSprint.
 * 
 * @author Gowsalya SG
 */
public class RowMapperSprint {

	/**
	 * Instantiates a new row mapper sprint.
	 */
	private RowMapperSprint() {

	}

	/** The Constant SprintRowMapperLambda. */
	public static final RowMapper<Sprint> SprintRowMapperLambda = (rs, rownum) -> {
		Sprint sprint = new Sprint();
		sprint.setId(rs.getString(SprintModelConstants.getSprintId()));
		sprint.setName(rs.getString(SprintModelConstants.getSprintName()));
		sprint.setProjectId(rs.getString(SprintModelConstants.getProjectId()));
		sprint.setGeneratedDate(rs.getDate(SprintModelConstants.getGeneratedDate()));
		sprint.setSprintDays(rs.getInt(SprintModelConstants.getSprintDays()));
		return sprint;
	};

}
