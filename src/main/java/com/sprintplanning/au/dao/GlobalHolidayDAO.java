package com.sprintplanning.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprintplanning.au.model.GlobalHoliday;

/**
 * The Interface GlobalHolidayDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface GlobalHolidayDAO {

	/**
	 * Save global holiday.
	 *
	 * @param g the g
	 */
	public void saveGlobalHoliday(GlobalHoliday g);
	
    /**
     * Gets the global holiday.
     *
     * @param d the d
     * @return the global holiday
     */
    public GlobalHoliday getGlobalHoliday(String d);
   
    /**
     * Gets the all global holiday.
     *
     * @return the all global holiday
     */
    public List<GlobalHoliday> getAllGlobalHoliday();
 
}
