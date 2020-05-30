package com.sprintplanning.au.filters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sprintplanning.au.config.ExcelGenerator;
import com.sprintplanning.au.model.Dependency;
import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.service.TaskService;

/**
 * The Class TaskFilters.
 * 
 * @author Rohan Pawar
 */
public class TaskFilters {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Gets the all tasks.
	 *
	 * @param projectId the project id
	 * @return the all tasks

	System.out.println(e);
	}
	
	public List<Task> getAllTasks(String projectId) { 
		TaskService taskService = new TaskService();
		return taskService.getTaskDAO().getAllTasksForProject(projectId);
	}

	/**
	 * Dependency task mapper.
	 *
	 * @param tasks        the tasks
	 * @param dependencies the dependencies
	 * @return the map
	 */
	public Map<String, Task> dependencyTaskMapper(List<Task> tasks, List<Dependency> dependencies) {
		HashMap<String, Task> mapper = new HashMap<>();
		for (Task task : tasks) {
			task.setQueuePriority(0);
			List<Task> tempDependencies = new ArrayList<>();
			for (Dependency dependency : dependencies) {
				if (dependency.getDependencyId().equals(task.getId())) {
					Task tempTask = taskFinder(tasks, dependency.getTaskId());
					tempTask.setDependencySize(tempTask.getDependencySize()+1);
					tempDependencies.add(tempTask);
				}
			}
			task.setDependencies(tempDependencies);
			mapper.put(task.getId(), task);
		}
		return subTaskMapper(mapper);
	}

	public Map<String, Task> subTaskMapper(Map<String, Task> mapper) {
		for (Task task : mapper.values()) {
			if (mapper.containsKey(task.getParentId())) {
				Task parentTask = mapper.get(task.getParentId());
				List<Task> subTasks = new ArrayList<>();
				try {
					subTasks.addAll(parentTask.getSubTasks());
				} catch (NullPointerException e) {
					LOGGER.log(Level.INFO, e.toString());
				}
				subTasks.add(task);
				parentTask.setSubTasks(subTasks);
				mapper.put(task.getParentId(), parentTask);
			}
		}
		return mapper;
	}

	/**
	 * Task finder.
	 *
	 * @param tasks  the tasks
	 * @param taskId the task id
	 * @return the task
	 */
	public Task taskFinder(List<Task> tasks, String taskId) {
		for (Task task : tasks) {
			if (task.getId().equals(taskId)) {
				return task;
			}
		}
		return new Task();
	}

	/**
	 * Assign priority.
	 *
	 * @param mapperTask the mapper task
	 */
	public Map<String, Task> assignPriority(Map<String, Task> mapperTask) {
		for (Task task : mapperTask.values()) {
			for (Task dependentTask : task.getDependencies()) {
				if (task.getQueuePriority() == 0 || task.getQueuePriority() == dependentTask.getQueuePriority() - 1 || dependentTask.getQueuePriority() == 0) {
					dependentTask.setQueuePriority(task.getQueuePriority() + 1);
				} else if (dependentTask.getQueuePriority() != 0) {
					dependentTask.setQueuePriority(dependentTask.getQueuePriority() + task.getQueuePriority());
				}
			}
		}
		return mapperTask;
	}

	/**
	 * Task filter.
	 *
	 * @param mapperTask the mapper task
	 * @return the queue
	 */
	public Queue<Task> taskFilter(Map<String, Task> mapperTask) {
		mapperTask = assignPriority(mapperTask);
		Comparator<Task> taskComparator = Comparator.comparing(Task::getQueuePriority)
				.thenComparing(Task::getDependencySize).reversed().thenComparing(Task::getId);
		PriorityQueue<Task> taskQueue = new PriorityQueue<>(taskComparator);

		HashSet<String> taskIds = new HashSet<>();

		for (Task task : mapperTask.values()) {
			for (Task dependTask : task.getDependencies()) {
				taskIds.add(dependTask.getId());
				taskQueue.add(dependTask);
			}
			if (task.getSubTasks() != null) {
				for (Task subTask : task.getSubTasks()) {
					if (!taskIds.contains(subTask.getId())) {
						taskIds.add(subTask.getId());
						taskQueue.add(subTask);
					}
				}
			} else if (!taskIds.contains(task.getId())) {
				taskIds.add(task.getId());
				taskQueue.add(task);
			}
		}
		return taskQueue;
	}
}
