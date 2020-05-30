package com.sprintplanning.au.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprintplanning.au.model.enums.TaskPriority;
import com.sprintplanning.au.model.enums.WorkStatus;

/**
 * The Class Task.
 * 
 * @author Rohan Pawar
 */
public class Task {
    


	/** The id. */
    private String id;
    
    private String Name;
    
    /** The project id. */
    private String projectId;
    
    /** The parent id. */
    private String parentId;
    
    /** The is assigned. */
    private boolean isAssigned;
    
    /** The sub tasks. */
    private List<Task> subTasks;
    
    /** The dependencies. */
    private List<Task> dependencies;
    
    /** The queue priority. */
    private int queuePriority;
    
    /** The dependency size. */
    private int dependencySize;

       
    /**
     * Gets the dependency size.
     *
     * @return the dependency size
     */
    public int getDependencySize() {
		return dependencySize;
	}

	/**
	 * Sets the dependency size.
	 *
	 * @param dependencySize the new dependency size
	 */
	public void setDependencySize(int dependencySize) {
		this.dependencySize = dependencySize;
	}

	/**
     * Gets the queue priority.
     *
     * @return the queue priority
     */
    public int getQueuePriority() {
		return queuePriority;
	}

	/**
	 * Sets the queue priority.
	 *
	 * @param queuePriority the new queue priority
	 */
	public void setQueuePriority(int queuePriority) {
		this.queuePriority = queuePriority;
	}

	/**
     * Gets the sub tasks.
     *
     * @return the sub tasks
     */
    public List<Task> getSubTasks() {
		return subTasks;
	}

	/**
	 * Sets the sub tasks.
	 *
	 * @param subTasks the new sub tasks
	 */
	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
	}

	/**
	 * Gets the dependencies.
	 *
	 * @return the dependencies
	 */
	public List<Task> getDependencies() {
		return dependencies;
	}

	/**
	 * Sets the dependencies.
	 *
	 * @param dependencies the new dependencies
	 */
	public void setDependencies(List<Task> dependencies) {
		this.dependencies = dependencies;
	}

	/**
     * Checks if is assigned.
     *
     * @return true, if is assigned
     */
    public boolean isAssigned() {
		return isAssigned;
	}

	/**
	 * Sets the assigned.
	 *
	 * @param isAssigned the new assigned
	 */
	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	/**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
		this.id = id;
	}
    
    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	/** The hours. */
    private Double hours;
    
    /** The start date. */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    
    /** The end date. */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    
    /** The priority. */
    private TaskPriority priority;
    
    /** The status. */
    private WorkStatus status;


    /**
     * Instantiates a new task.
     */
    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Returns the id field.
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the projectId field.
     * @return projectId
     */
    public String getProjectId() {
        return this.projectId;
    }

    /**
     * Returns the id field.
     *
     * @param projectId the new project id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Returns the parentId field.
     * @return parentId
     */
    public String getParentId() {
        return this.parentId;
    }

    /**
     * Returns the id field.
     *
     * @param parentId the new parent id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Returns the hours field.
     * @return hours
     */
    public Double getHours() {
        return this.hours;
    }

    /**
     * Sets the hours field.
     *
     * @param hours the new hours
     */
    public void setHours(Double hours) {
        this.hours = hours;
    }

    /**
     * Returns the startDate field.
     * @return start date
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the startDate field.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the endDate field.
     * @return end date
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the endDate field.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Returns the status.
     * @return status
     */
    public WorkStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status field.
     *
     * @param status the new status
     */
    public void setStatus(WorkStatus status) {
        this.status = status;
    }

    /**
     * Returns the priority.
     * @return priority
     */
    public TaskPriority getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority field.
     *
     * @param priority the new priority
     */
    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

	@Override
	public String toString() {
		return "Task [id=" + id + ", projectId=" + projectId + ", parentId=" + parentId + ", isAssigned=" + isAssigned
				+ ", subTasks=" + subTasks + ", dependencies=" + dependencies + ", queuePriority=" + queuePriority
				+ ", dependencySize=" + dependencySize + ", hours=" + hours + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", status=" + status + "]";
	}
    
    

}
