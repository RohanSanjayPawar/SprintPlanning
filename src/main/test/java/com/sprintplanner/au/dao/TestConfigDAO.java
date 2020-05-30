package com.sprintplanner.au.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sprintplanning.au.dao.ConfigurationDAO;
import com.sprintplanning.au.dao.ProjectSprintDAO;
import com.sprintplanning.au.model.Configuration;
import com.sprintplanning.au.model.ProjectSprint;
import com.sprintplanning.au.model.Sprint;
 
@PropertySource("classpath:application.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestConfigDAO {
     
    @Autowired
    private ConfigurationDAO configDAO;
    
    @Autowired
    private ProjectSprintDAO projectSprintDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setSprintId("1");
        configuration.setSprintDays(10);
        configDAO.saveConfiguration(configuration);
         
        List<Configuration> configurations = configDAO.getAllConfigurations();
        Assert.assertEquals(configuration.getSprintId(), configurations.get(0).getSprintId());
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddProjectSprint() {
        ProjectSprint projectSprint = new ProjectSprint();
        projectSprint.setProjectId("project-1");
        Sprint sprint1 = new Sprint();
        Sprint sprint2 = new Sprint();
        List<Sprint> sprintList = new ArrayList<>();
        sprintList.add(sprint1);
        sprintList.add(sprint2);
        
        projectSprint.setSprints(sprintList);
        projectSprintDAO.insertProjectSprint(projectSprint);
         
        ProjectSprint projectSprint2 = projectSprintDAO.getProjectSprintById(projectSprint.getProjectId()).getProjectSprint();
        		
        Assert.assertEquals(2, projectSprint2.getSprints().size());
        Assert.assertEquals(projectSprint.getProjectId(), projectSprint2.getProjectId());
    }
}