/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.domain;

import java.util.Date;

/**
 * Audit domain object
 * 
 * @author janm
 */
public class Audit {

	private int auditId;
	private Integer user;
	private Date auditDate;
	private String data;

	/**
	 * @return Returns the auditDate.
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * @param auditDate The auditDate to set.
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * @return Returns the auditId.
	 */
	public int getAuditId() {
		return auditId;
	}

	/**
	 * @param auditId The auditId to set.
	 */
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	/**
	 * @return Returns the data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data The data to set.
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return Returns the user.
	 */
	public Integer getUser() {
		return user;
	}

	/**
	 * @param user The user to set.
	 */
	public void setUser(Integer user) {
		this.user = user;
	}
}