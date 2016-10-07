/*
 * Created on Aug 24, 2004
 */
package com.apress.prospring.ch10.data;

import java.util.Date;
import java.util.List;

import com.apress.prospring.ch10.domain.Test;

/**
 * @author janm
 */
public interface TestDao {

	/**
	 * Returns all Test objects
	 * 
	 * @return List of Test objects
	 */
	public List getAll();

	/**
	 * Saves a Test object
	 * 
	 * @param test The test object to be persisted
	 */
	public void save(Test test);

	/**
	 * Deletes an existing Test object identified by testId
	 * 
	 * @param testId Test identity
	 */
	public void delete(int testId);

	/**
	 * Returns a Test object identified by testId
	 * 
	 * @param testId Test identity
	 * @return Test object
	 */
	public Test getById(int testId);
	
	/**
	 * Returns List of Test objects 
	 * 
	 * @param name The name
	 * @param runDate The run date
	 * @return List of Test objects
	 */
	public List getByNameAndRunDate(String name, Date runDate);
	
	/**
	 * Updates the Name column in a row identified by testId
	 * 
	 * @param testId Test row identity
	 * @param name New name
	 */
	public void updateName(int testId, String name);

}