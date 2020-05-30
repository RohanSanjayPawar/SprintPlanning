package com.sprintplanning.au.row_mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sprintplanning.au.constants.TaskModelConstants;
import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.model.enums.TaskPriority;
import com.sprintplanning.au.model.enums.WorkStatus;

/**
 * The Class RowmapperTask.
 * 
 * @author Rohan Pawar
 */
public class RowmapperTask {

	/**
	 * Instantiates a new rowmapper task.
	 */
	private RowmapperTask() {

	}
	
	/** The Constant taskRowMapperLambda. */
	public static final RowMapper<Task> taskRowMapperLambda = (rs, rownum) -> {
		Task task = new Task();
		task.setId(rs.getString(TaskModelConstants.getTaskId()));
		task.setProjectId(rs.getString(TaskModelConstants.getProjectId()));
		task.setParentId(rs.getString(TaskModelConstants.getTaskParentId()));
		task.setHours(rs.getDouble(TaskModelConstants.getTaskHours()));
		
		switch(rs.getString(TaskModelConstants.getTaskPriority())) {
			case "LOW":
				task.setPriority(TaskPriority.LOW);
				break;
			case "NORMAL":
				task.setPriority(TaskPriority.NORMAL);
				break;
			case "HIGH":
				task.setPriority(TaskPriority.HIGH);
				break;
			default:
				task.setPriority(TaskPriority.LOW);
				break;
		}
		
		switch(rs.getString(TaskModelConstants.getTaskStatus())) {
		case "YET_TO_START":
			task.setStatus(WorkStatus.YET_TO_START);
			break;
		case "STARTED":
			task.setStatus(WorkStatus.STARTED);
			break;
		case "WORK_IN_PROGRESS":
			task.setStatus(WorkStatus.WORK_IN_PROGRESS);
			break;
		case "ON_HOLD":
			task.setStatus(WorkStatus.ON_HOLD);
			break;
		case "COMPLETED":
			task.setStatus(WorkStatus.COMPLETED);
			break;
		default:
			task.setStatus(WorkStatus.YET_TO_START);
			break;
		}
		task.setStartDate(rs.getDate(TaskModelConstants.getTaskStartDate()));
		task.setEndDate(rs.getDate(TaskModelConstants.getTaskEndDate()));
		return task;
	};
	
}
