/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.data;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.ch10.domain.Order;


/**
 * @author janm
 */
public class SqlMapClientOrderDao extends SqlMapClientDaoSupport implements OrderDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.OrderDao#getById(int)
	 */
	public Order getById(int orderId) {
		return (Order)getSqlMapClientTemplate().queryForObject("getOrderById", new Integer(orderId));
	}

}
