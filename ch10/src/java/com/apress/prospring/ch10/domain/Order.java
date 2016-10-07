/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.domain;

import java.util.List;

/**
 * @author janm
 */
public class Order {

	private int orderId;
	private int customer;
	private List orderLines;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(100);
		result.append("Order { orderId: ");
		result.append(orderId);
		result.append(", customer: ");
		result.append(customer);
		result.append(", orderLines: ");
		result.append(orderLines);
		result.append(" }");
		return result.toString();
	}

	// Getters and Setters

	/**
	 * @return Returns the customer.
	 */
	public int getCustomer() {
		return customer;
	}

	/**
	 * @param customer The customer to set.
	 */
	public void setCustomer(int customer) {
		this.customer = customer;
	}

	/**
	 * @return Returns the orderId.
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId The orderId to set.
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return Returns the orderLines.
	 */
	public List getOrderLines() {
		return orderLines;
	}

	/**
	 * @param orderLines The orderLines to set.
	 */
	public void setOrderLines(List orderLines) {
		this.orderLines = orderLines;
	}
}