package com.sprintplanning.au.model;

import java.util.UUID;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprintplanning.au.model.enums.WorkStatus;

/**
 * The Class ProjectModel.
 * 
 * @author Gowsalya SG 
 *  
 *  */
public class ProjectModel {
    
    /** The id. */
    private String id;
    
    /** The name. */
    private String name;
    
    /** The description. */
    private String description;
    
    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
		this.id = id;
	}

	/** The start date. */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    
    /** The estimated end date. */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date estimatedEndDate;
    
    /** The actual end date. */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date actualEndDate;
    
    /** The status. */
    private WorkStatus status;

    /**
     * Instantiates a new project model.
     */
    public ProjectModel() {
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
     * Returns the name field.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name field.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description.
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description field.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Returns the estimatedEndDate field.
     * @return estimated end date
     */
    public Date getEstimatedEndDate() {
        return this.estimatedEndDate;
    }

    /**
     * Sets the estimatedEndDate field.
     *
     * @param estimatedEndDate the new estimated end date
     */
    public void setEstimatedEndDate(Date estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
    }

    /**
     * Returns the actualEndDate field.
     * @return actual end date
     */
    public Date getActualEndDate() {
        return this.actualEndDate;
    }

    /**
     * Sets the actualEndDate field.
     *
     * @param actualEndDate the new actual end date
     */
    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ProjectModel [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", estimatedEndDate=" + estimatedEndDate + ", actualEndDate=" + actualEndDate + ", status=" + status
				+ "]";
	}
    
    
}
