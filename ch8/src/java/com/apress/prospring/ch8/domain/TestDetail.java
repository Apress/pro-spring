/*
 * Created on Aug 16, 2004
 */
package com.apress.prospring.ch8.domain;

/**
 * @author janm
 */
public class TestDetail {

	private int testDetailId;
	private int test;
	private String data;

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
	 * @return Returns the test.
	 */
	public int getTest() {
		return test;
	}

	/**
	 * @param test The test to set.
	 */
	public void setTest(int test) {
		this.test = test;
	}

	/**
	 * @return Returns the testDetailId.
	 */
	public int getTestDetailId() {
		return testDetailId;
	}

	/**
	 * @param testDetailId The testDetailId to set.
	 */
	public void setTestDetailId(int testDetailId) {
		this.testDetailId = testDetailId;
	}
}