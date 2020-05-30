package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.GlobalHolidayModelConstants;
import com.sprintplanning.au.model.GlobalHoliday;

/**
 * The Class RowMapperGlobalHoliday.
 * 
 * @author Gowsalya SG
 */
public class RowMapperGlobalHoliday {

	/**
	 * Instantiates a new row mapper global holiday.
	 */
	private RowMapperGlobalHoliday() {

	}

	/** The Constant GlobalHolidayRowMapperLambda. */
	public static final RowMapper<GlobalHoliday> GlobalHolidayRowMapperLambda = (rs, rownum) -> {
		GlobalHoliday globalHoliday = new GlobalHoliday();
		globalHoliday.setDateOfHoliday(rs.getDate(GlobalHolidayModelConstants.getDateOfHoliday()));
		globalHoliday.setHolidayDescription(rs.getString(GlobalHolidayModelConstants.getHolidayDescription()));
		return globalHoliday;
	};

}
