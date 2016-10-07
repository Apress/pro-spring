/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.domain;

/**
 * @author janm
 */
public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private CustomerDetail customerDetail;
	private CustomerDetail customerGossip;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(100);
		result.append("Customer { customerId: ");
		result.append(customerId);
		result.append(", firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", customerDetail: ");
		result.append(customerDetail);
		result.append(", customerGossip: ");
		result.append(customerGossip);
		result.append(" }");
		return result.toString();
	}

	// Getters and setters

	/**
	 * @return Returns the customerDetail.
	 */
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	/**
	 * @param customerDetail The customerDetail to set.
	 */
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	/**
	 * @return Returns the customerId.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId The customerId to set.
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Returns the customerGossip.
	 */
	public CustomerDetail getCustomerGossip() {
		return customerGossip;
	}

	/**
	 * @param customerGossip The customerGossip to set.
	 */
	public void setCustomerGossip(CustomerDetail customerGossip) {
		this.customerGossip = customerGossip;
	}
}