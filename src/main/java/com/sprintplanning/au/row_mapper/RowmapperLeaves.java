package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.LeavesModelConstants;
import com.sprintplanning.au.model.DeveloperLeaves;

/**
 * The Class RowmapperLeaves.
 * 
 * @author Rohan Pawar
 */
public class RowmapperLeaves {
	
	/**
	 * Instantiates a new rowmapper leaves.
	 */
	private RowmapperLeaves() {

	}

	/** The Constant leavesnRowMapperLambda. */
	public static final RowMapper<DeveloperLeaves> leavesnRowMapperLambda = (rs, rownum) -> {
		DeveloperLeaves developerLeaves = new DeveloperLeaves();
		developerLeaves.setUserId(rs.getString(LeavesModelConstants.getDeveloperId()));
		developerLeaves.setStartDayOfLeave(rs.getDate(LeavesModelConstants.getStartDateOfLeave()));
		developerLeaves.setEndDayOfLeave(rs.getDate(LeavesModelConstants.getEndDateOfLeave()));
		developerLeaves.setReasonForLeave(rs.getString(LeavesModelConstants.getReasonForLeave()));
		return developerLeaves;
	};
}
