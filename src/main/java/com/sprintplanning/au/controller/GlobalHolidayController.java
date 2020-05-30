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

import com.sprintplanning.au.model.GlobalHoliday;
import com.sprintplanning.au.service.GlobalHolidayService;

/**
 * The Class GlobalHolidayController.
 */
@RestController
@RequestMapping("/api/globalholiday")
@CrossOrigin
public class GlobalHolidayController {
	
	/** The global holiday service. */
	@Autowired
	GlobalHolidayService globalHolidayService;
	
	/**
	 * Preset message.
	 *
	 * @return the list
	 */
	@GetMapping("")
	public List<GlobalHoliday> getAllHolidays() {
		return globalHolidayService.getGlobalHolidayDAO().getAllGlobalHoliday();
	}
	
	/**
	 * Gets the global holiday by id.
	 *
	 * @param GlobalHolidaydate the global holidaydate
	 * @return the global holiday by id
	 */
	@GetMapping("/{date}")
	public GlobalHoliday getGlobalHolidayById(@PathVariable("date") String globalHolidaydate) {
		return globalHolidayService.getGlobalHolidayDAO().getGlobalHoliday(globalHolidaydate);
	}
	

	/**
	 * Adds the global holiday.
	 *
	 * @param globalHoliday the global holiday
	 */
	@PostMapping(path="/add", consumes = "application/json")
	public void addGlobalHoliday(@RequestBody GlobalHoliday globalHoliday) {
		globalHolidayService.getGlobalHolidayDAO().saveGlobalHoliday(globalHoliday);
	}
}