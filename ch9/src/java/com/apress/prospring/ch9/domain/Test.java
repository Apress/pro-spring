/*
 * Created on Sep 1, 2004
 */
package com.apress.prospring.ch9.domain;

import java.util.Date;

/**
 * @author janm
 */
public class Test {

	private int testId;
	private String name;
	private Date runDate;
	private int version;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("Test { testId=");
		result.append(testId);
		result.append(", name=");
		result.append(name);
		result.append(", runDate=");
		result.append(runDate);
		result.append(", version=");
		result.append(version);
		result.append("}");

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
	 * @return Returns the runDate.
	 */
	public Date getRunDate() {
		return runDate;
	}

	/**
	 * @param runDate The runDate to set.
	 */
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	/**
	 * @return Returns the testId.
	 */
	public int getTestId() {
		return testId;
	}

	/**
	 * @param testId The testId to set.
	 */
	public void setTestId(int testId) {
		this.testId = testId;
	}

	/**
	 * @return Returns the version.
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version The version to set.
	 */
	public void setVersion(int version) {
		this.version = version;
	}
}