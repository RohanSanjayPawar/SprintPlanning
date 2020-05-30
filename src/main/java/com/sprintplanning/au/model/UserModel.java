package com.sprintplanning.au.model;

import java.util.UUID;

import com.sprintplanning.au.model.enums.UserRole;

/**
 * The Class UserModel.
 * 
 * @author Rohan Pawar
 */
public class UserModel {
    
    /** The id. */
    private String id;
    
    /** The username. */
    private String username;
    
    /** The display name. */
    private String displayName;
    
    /** The email. */
    private String email;
    
    /** The efficiency. */
    private Double efficiency;
    
    /** The role. */
    private UserRole role;
    
    /** The auth code. */
    private String authCode;
    
    /** The work hours. */
    private double workHours;
    
    /** The assigned tasks. */
    private int assignedTasks;

    /**
     * Gets the assigned tasks.
     *
     * @return the assigned tasks
     */
    public int getAssignedTasks() {
		return assignedTasks;
	}

	/**
	 * Sets the assigned tasks.
	 *
	 * @param assignedTasks the new assigned tasks
	 */
	public void setAssignedTasks(int assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	/**
     * Gets the work hours.
     *
     * @return the work hours
     */
    public double getWorkHours() {
		return workHours;
	}

	/**
	 * Sets the work hours.
	 *
	 * @param workHours the new work hours
	 */
	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}

	/**
     * Gets the auth code.
     *
     * @return the auth code
     */
    public String getAuthCode() {
		return authCode;
	}

	/**
	 * Sets the auth code.
	 *
	 * @param authCode the new auth code
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
     * Instantiates a new user model.
     */
    public UserModel() {
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
     * Returns the username field.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the username field.
	 *
	 * @param username the new username
	 */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the display name.
     * @return display name
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Sets the displaName field.
     *
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the email field.
     * @return efficiency
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email field.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the efficiency.
     * @return efficiency
     */
    public Double getEfficiency() {
        return this.efficiency;
    }

    /**
     * Sets the efficiency field.
     *
     * @param efficiency the new efficiency
     */
    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }

    /**
     * Returns the role.
     * @return role
     */
    public UserRole getRole() {
        return this.role;
    }

    /**
     * Sets the role field.
     *
     * @param role the new role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", displayName=" + displayName + ", email=" + email
				+ ", efficiency=" + efficiency + ", role=" + role + ", authCode=" + authCode + ", workHours="
				+ workHours + ", assignedTasks=" + assignedTasks + "]";
	}
    
    
}

