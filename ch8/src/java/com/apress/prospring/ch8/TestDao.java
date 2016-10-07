/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch8;

import java.util.List;

import com.apress.prospring.ch8.domain.Test;

/**
 * Test dao interface
 * 
 * @author janm
 */
public interface TestDao {

	/**
	 * Returns all Test records with the same name
	 * 
	 * @param name The name
	 * @return List of Test domain objects
	 */
	public List getByName(String name);
	
	/**
	 * Returns all Test records
	 * 
	 * @return List of Test domain objects
	 */
	public List getAll();
	
	/**
	 * Updates an existing Test record
	 * 
	 * @param test The record to update
	 */
	public void update(Test test);
	
	/**
	 * Inserts a new test record
	 * 
	 * @param test Test to be updated
	 */
	public void insert(Test test);
	
	/**
	 * Deletes an existing test record
	 * 
	 * @param testId Record identity
	 */
	public void delete(int testId);
}
