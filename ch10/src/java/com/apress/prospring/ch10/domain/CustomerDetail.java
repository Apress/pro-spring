/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.domain;

/**
 * @author janm
 */
public class CustomerDetail {

	private int customerDetailId;
	private String data;

	// Operations
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(100);
		result.append("CustomerDetail { customerDetailId: ");
		result.append(customerDetailId);
		result.append(", data: ");
		result.append(data);
		result.append(" }");
		return result.toString();
	}	
	
	// Getters and setters	
	
	/**
	 * @return Returns the customerDetailId.
	 */
	public int getCustomerDetailId() {
		return customerDetailId;
	}

	/**
	 * @param customerDetailId The customerDetailId to set.
	 */
	public void setCustomerDetailId(int customerDetailId) {
		this.customerDetailId = customerDetailId;
	}

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
}