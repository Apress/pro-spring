/*
 * Created on Aug 25, 2004
 */
package com.apress.prospring.ch10.domain;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class OrderLine {

	private int orderLineId;
	private int order;
	private String product;
	private BigDecimal price;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(50);
		result.append("OrderLine { orderLineId: ");
		result.append(orderLineId);
		result.append(", order: ");
		result.append(order);
		result.append(", product: ");
		result.append(product);
		result.append(", price");
		result.append(price);
		result.append(" }");
		return result.toString();
	}

	// Getters and Setters

	/**
	 * @return Returns the order.
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order The order to set.
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @return Returns the orderLineId.
	 */
	public int getOrderLineId() {
		return orderLineId;
	}

	/**
	 * @param orderLineId The orderLineId to set.
	 */
	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}

	/**
	 * @return Returns the price.
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price The price to set.
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return Returns the product.
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product The product to set.
	 */
	public void setProduct(String product) {
		this.product = product;
	}
}