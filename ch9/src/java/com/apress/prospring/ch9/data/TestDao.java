/*
 * Created on Sep 1, 2004
 */
package com.apress.prospring.ch9.data;

import java.util.List;

import com.apress.prospring.ch9.domain.Test;


/**
 * @author janm
 */
public interface TestDao {

	public List getAll();
	
	public Test getById(int testId);
	
	public void save(Test test);
	
	public void delete(int testId);
}
