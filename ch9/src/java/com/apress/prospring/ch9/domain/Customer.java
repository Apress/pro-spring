/*
 * Created on 02-Sep-2004
 */
package com.apress.prospring.ch9.domain;

import java.util.Set;

/**
 * @author janm
 */
public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private Set addresses;
	private Set permissions;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(250);
		result.append("Customer { customerId=");
		result.append(customerId);
		result.append(", firstName=");
		result.append(firstName);
		result.append(", lastName=");
		result.append(lastName);
		result.append(", addresses=");
		result.append(addresses);
		result.append(", permissions=");
		result.append(permissions);
		result.append(" }");
		return result.toString();
	}

	// Getters and Setters

	/**
	 * @return Returns the addresses.
	 */
	public Set getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses The addresses to set.
	 */
	public void setAddresses(Set addresses) {
		this.addresses = addresses;
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
	 * @return Returns the permissions.
	 */
	public Set getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions The permissions to set.
	 */
	public void setPermissions(Set permissions) {
		this.permissions = permissions;
	}
}