package com.sprintplanning.au.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.constants.GlobalHolidayModelConstants;
import com.sprintplanning.au.dao.GlobalHolidayDAO;
import com.sprintplanning.au.model.GlobalHoliday;
import com.sprintplanning.au.queries.GlobalHolidayModelQueries;
import com.sprintplanning.au.row_mapper.RowMapperGlobalHoliday;

/**
 * The Class GlobalHolidayDAOImpl.
 * 
 * @author Gowsalya SG
 */
@Repository
public class GlobalHolidayDAOImpl implements GlobalHolidayDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new global holiday DAO impl.
	 */
	public GlobalHolidayDAOImpl() {

	}

	/**
	 * Instantiates a new global holiday DAO impl.
	 *
	 * @param dataSource the data source
	 */
	public GlobalHolidayDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Save global holiday.
	 *
	 * @param globalHoliday the global holiday
	 */
	@Override
	public void saveGlobalHoliday(GlobalHoliday globalHoliday) {
		try {
			String addGlobalHolidayQuery = GlobalHolidayModelQueries.getAddGlobalholiday();
			jdbcTemplate.update(addGlobalHolidayQuery, globalHoliday.getDateOfHoliday(),
					globalHoliday.getHolidayDescription());
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}

	/**
	 * Gets the global holiday.
	 *
	 * @param d the d
	 * @return the global holiday
	 */
	@Override
	public GlobalHoliday getGlobalHoliday(String d) {
		try {
			String getGlobalHolidayDetails = GlobalHolidayModelQueries.getGetGlobalholiday() + "'" + d + "'";
			return jdbcTemplate.query(getGlobalHolidayDetails, (ResultSet rs) -> {
				if (rs.next()) {
					GlobalHoliday globalHoliday = new GlobalHoliday();
					globalHoliday.setDateOfHoliday(rs.getDate(GlobalHolidayModelConstants.getDateOfHoliday()));
					globalHoliday
							.setHolidayDescription(rs.getString(GlobalHolidayModelConstants.getHolidayDescription()));

					return globalHoliday;
				}
				return new GlobalHoliday();
			});
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new GlobalHoliday();
	}

	/**
	 * Gets the all global holiday.
	 *
	 * @return the all global holiday
	 */
	@Override
	public List<GlobalHoliday> getAllGlobalHoliday() {
		try {
			String getAllGlobalHolidayDetails = GlobalHolidayModelQueries.getGetAllGlobalholiday();
			return jdbcTemplate.query(getAllGlobalHolidayDetails, RowMapperGlobalHoliday.GlobalHolidayRowMapperLambda);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		return new ArrayList<>();
	}
}
