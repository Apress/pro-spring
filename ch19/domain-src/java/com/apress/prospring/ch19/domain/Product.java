/*
 * Created on 02-Nov-2004
 */
package com.apress.prospring.ch19.domain;

/**
 * @author janm
 */
public class Product {

	private int productId;
	private String name;
	private String description;

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Product) return ((Product)obj).productId == productId;
		return false;
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
		result.append("Product {productId=");
		result.append(productId);
		result.append(", name=");
		result.append(name);
		result.append(", description=");
		result.append(description);
		result.append(" }");
		return result.toString();
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
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
