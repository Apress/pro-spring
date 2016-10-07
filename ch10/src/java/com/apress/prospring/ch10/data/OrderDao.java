/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.data;

import com.apress.prospring.ch10.domain.Order;


/**
 * @author janm
 */
public interface OrderDao {

	/**
	 * Returns an Order object identified by orderId
	 * 
	 * @param orderId Order identity
	 * @return Order object
	 */
	public Order getById(int orderId);
}
