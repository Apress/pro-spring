/*
 * Created on 02-Sep-2004
 */
package com.apress.prospring.ch9.domain;

/**
 * @author janm
 */
public class Permission {

	private int permissionId;
	private String name;

	// Operations
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(50);
		result.append("Permission { permissionId=");
		result.append(permissionId);
		result.append(", name=");
		result.append(name);
		result.append(" }");
		return result.toString();
	}	
	
	// Getters and setters
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the permissionId.
	 */
	public int getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId The permissionId to set.
	 */
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
}