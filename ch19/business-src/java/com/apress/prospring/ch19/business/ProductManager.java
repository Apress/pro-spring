/*
 * Created on 02-Nov-2004
 */
package com.apress.prospring.ch19.business;

import java.util.List;

import com.apress.prospring.ch19.domain.Product;


/**
 * @author janm
 */
public interface ProductManager {
	
	/**
	 * Finds all available products
	 * @return List of Products
	 */
	public List<Product> findAll();
}
