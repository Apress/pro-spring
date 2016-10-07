/*
 * Created on 02-Sep-2004
 */
package com.apress.prospring.ch9.domain;

/**
 * @author janm
 */
public class CustomerAddress {

	private int customerAddressId;
	private int customer;
	private String line1;
	private String line2;
	private String city;
	private String postCode;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(100);
		result.append("CustomerAddress { customerAddressId=");
		result.append(customerAddressId);
		result.append(", line1=");
		result.append(line1);
		result.append(", line2=");
		result.append(line2);
		result.append(", city=");
		result.append(city);
		result.append(", postCode=");
		result.append(postCode);
		result.append(" }");
		return result.toString();
	}

	// Getters and Setters

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return Returns the customerAddressId.
	 */
	public int getCustomerAddressId() {
		return customerAddressId;
	}

	/**
	 * @param customerAddressId The customerAddressId to set.
	 */
	public void setCustomerAddressId(int customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	/**
	 * @return Returns the line1.
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * @param line1 The line1 to set.
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * @return Returns the line2.
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @param line2 The line2 to set.
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * @return Returns the postCode.
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode The postCode to set.
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

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
}