/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.data;

import com.apress.prospring.ch10.domain.Customer;


/**
 * @author janm
 */
public interface CustomerDao {

	/**
	 * Returns a Customer domain object identified by customerId
	 * 
	 * @param customerId Customer identity
	 * @return Customer domain object
	 */
	public Customer getById(int customerId);
}
