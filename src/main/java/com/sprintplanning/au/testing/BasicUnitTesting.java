package com.sprintplanning.au.testing;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.sprintplanning.au.dao.GlobalHolidayDAO;
import com.sprintplanning.au.dao.impl.GlobalHolidayDAOImpl;
import com.sprintplanning.au.model.GlobalHoliday;
import com.sprintplanning.au.service.GlobalHolidayService;


@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTesting {

	@InjectMocks
	GlobalHolidayService globalHolidayService;
	@Mock
	GlobalHolidayDAOImpl globalHolidayDao;
	
	
	 
	@Before
	public void beforeService() {
		MockitoAnnotations.initMocks(this);
		// 	ansService = new AnswerService(ansDao);
    }
		
	
	
	@Test
	public void getAllAnswers() throws Exception {
		
		GlobalHoliday at = new GlobalHoliday();
		GlobalHoliday at1 = new GlobalHoliday();
		List<GlobalHoliday> list = new ArrayList<>();
		list.add(at);
		list.add(at1);
		
		when(globalHolidayDao.getAllGlobalHoliday()).thenReturn(list);
		
		Assert.assertEquals(globalHolidayService.getGlobalHolidayDAO().getAllGlobalHoliday(), list);
		
	}
	
}