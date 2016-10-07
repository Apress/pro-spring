/*
 * Created on 02-Sep-2004
 */
package com.apress.prospring.ch9.data;

import java.util.List;

import com.apress.prospring.ch9.domain.Customer;


/**
 * @author janm
 */
public interface CustomerDao {
	
	public List getAll();
	
	public List getAllWithOnlyOnePermission();

	public void save(Customer customer);
}
