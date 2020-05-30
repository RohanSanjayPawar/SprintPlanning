package com.sprintplanning.au.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.sprintplanning.au.dao.ProjectSprintDAO;
import com.sprintplanning.au.model.DeveloperTask;
import com.sprintplanning.au.model.ProjectSprint;
import com.sprintplanning.au.model.Sprint;
import com.sprintplanning.au.model.SprintResponse;
import com.sprintplanning.au.queries.ProjectSprintQueries;

@Repository
public class ProjectSprintDAOImpl implements ProjectSprintDAO {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	private static final String WEEK = "WEEK-";

	public ProjectSprintDAOImpl() {

	}

	public ProjectSprintDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertProjectSprint(ProjectSprint projectSprint) {
		try {
			SprintDAOImpl sprintDAOImpl = new SprintDAOImpl();
			for (Sprint sprint : projectSprint.getSprints()) {
				sprintDAOImpl.saveSprint(sprint);
			}
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
	}

	@Override
	public SprintResponse getProjectSprintById(String projectId) {
		try {
			String getProjectSprint = ProjectSprintQueries.getGetProjectSprint() + projectId + " ORDER BY d.SPRINT_ID";
			return jdbcTemplate.query(getProjectSprint, new ResultSetExtractor<SprintResponse>() {
				@Override
				public SprintResponse extractData(ResultSet rs) throws SQLException {
					SprintResponse sprintResponse = new SprintResponse();
					List<Sprint> sprintList = new ArrayList<>();
					ProjectSprint projectSprint = new ProjectSprint();
					HashMap<String, Sprint> sprintId = new HashMap<>();
					while (rs.next()) {
						if (!sprintId.containsKey(rs.getString(6))) {
							Sprint sprint = new Sprint();
							sprint.setId(rs.getString(18));
							sprint.setName(rs.getString(19));
							sprint.setProjectId(rs.getString(20));
							sprint.setGeneratedDate(rs.getDate(21));
							sprint.setSprintDays(rs.getInt(22));
							sprint.setSprintTasks(new ArrayList<>());
							sprintId.put(sprint.getId(), sprint);
						}

						DeveloperTask developerTask = new DeveloperTask();
						developerTask.setDeveloperTaskId(rs.getString(1));
						developerTask.setUserId(rs.getString(2));
						developerTask.setTaskId(rs.getString(3));
						developerTask.setEstimatedHours(rs.getDouble(5));
						developerTask.setStartDate(rs.getDate(15));
						developerTask.setEndDate(rs.getDate(16));
						developerTask.setSprintId(rs.getString(6));
						Sprint tempSprint = sprintId.get(developerTask.getSprintId());
						List<DeveloperTask> developerTasks = tempSprint.getSprintTasks();
						developerTasks.add(developerTask);
						sprintId.get(tempSprint.getId()).setSprintTasks(developerTasks);
						projectSprint.setGeneratedDate(rs.getDate(21));
					}

					for (Sprint sprint : sprintId.values()) {
						sprintList.add(sprint);
					}
					projectSprint.setProjectId(projectId);
					projectSprint.setSprints(sprintList);
					sprintResponse.setMessage("SUCCESS");
					sprintResponse.setProjectSprint(projectSprint);
					return sprintResponse;
				}
			});
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		SprintResponse sprintResponse = new SprintResponse();
		sprintResponse.setMessage("FAILURE");
		return sprintResponse;
	}

	@Override
	public SprintResponse getProjectSprintWeekly(String projectId) {
		try {
			String getProjectSprint = ProjectSprintQueries.getGetProjectSprint() + projectId + " ORDER BY d.SPRINT_ID";
			return jdbcTemplate.query(getProjectSprint, new ResultSetExtractor<SprintResponse>() {
				@Override
				public SprintResponse extractData(ResultSet rs) throws SQLException {
					SprintResponse sprintResponse = new SprintResponse();
					List<Sprint> weeklySprintList = new ArrayList<>();
					ProjectSprint projectSprint = new ProjectSprint();
					HashMap<String, Sprint> sprintId = new HashMap<>();
					while (rs.next()) {
						if (!sprintId.containsKey(WEEK + rs.getString(24))) {
							Sprint sprint = new Sprint();
							sprint.setId(WEEK + rs.getString(24));
							sprint.setName(rs.getString(19));
							sprint.setProjectId(rs.getString(20));
							sprint.setGeneratedDate(rs.getDate(21));
							sprint.setSprintDays(rs.getInt(22));
							sprint.setSprintTasks(new ArrayList<>());
							sprintId.put(sprint.getId(), sprint);
						}

						DeveloperTask developerTask = new DeveloperTask();
						developerTask.setDeveloperTaskId(rs.getString(1));
						developerTask.setUserId(rs.getString(2));
						developerTask.setTaskId(rs.getString(3));
						developerTask.setEstimatedHours(rs.getDouble(5));
						developerTask.setStartDate(rs.getDate(15));
						developerTask.setEndDate(rs.getDate(16));
						developerTask.setSprintId(WEEK + rs.getString(24));
						Sprint tempSprint = sprintId.get(WEEK + rs.getString(24));
						List<DeveloperTask> developerTasks = tempSprint.getSprintTasks();
						developerTasks.add(developerTask);
						sprintId.get(tempSprint.getId()).setSprintTasks(developerTasks);
						projectSprint.setGeneratedDate(rs.getDate(21));
					}

					for (Sprint sprint : sprintId.values()) {
						weeklySprintList.add(sprint);
					}
					projectSprint.setProjectId(projectId);
					projectSprint.setSprints(weeklySprintList);
					sprintResponse.setMessage("SUCCESS");
					sprintResponse.setProjectSprint(projectSprint);
					return sprintResponse;
				}
			});
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		SprintResponse sprintResponse = new SprintResponse();
		sprintResponse.setMessage("FAILURE");
		return sprintResponse;
	}

}
