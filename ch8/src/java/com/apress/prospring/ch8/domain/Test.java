/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch8.domain;

import java.util.List;

/**
 * Test domain object
 * 
 * @author janm
 */
public class Test {

	private int testId;
	private String name;
	private List details;

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
	 * @return Returns the details.
	 */
	public List getDetails() {
		return details;
	}

	/**
	 * @param details The details to set.
	 */
	public void setDetails(List details) {
		this.details = details;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "TestId: " + testId + ", name: " + name;
	}
}