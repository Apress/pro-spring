/*
 * Created on Oct 24, 2004
 */
package com.apress.prospring.ch17.domain;

import java.util.Date;

/**
 * @author janm
 */
public class Product {

	private int productId;
	private String name;
	private Date expirationDate;

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Product) {
			Product rhs = (Product) obj;
			return rhs.productId == productId;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return productId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(50);
		result.append("Product { productId=");
		result.append(productId);
		result.append(", name=");
		result.append(name);
		result.append(", expirationDate=");
		result.append(expirationDate);
		result.append(" }");
		return result.toString();
	}

	/**
	 * @return Returns the expirationDate.
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate The expirationDate to set.
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the productId.
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId The productId to set.
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
}