/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.data;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.ch10.domain.Customer;


/**
 * @author janm
 */
public class SqlMapClientCustomerDao extends SqlMapClientDaoSupport implements CustomerDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.CustomerDao#getById(int)
	 */
	public Customer getById(int customerId) {
		return (Customer)getSqlMapClientTemplate().queryForObject("getCustomerById", new Integer(customerId));
	}

}
