/*
 * Created on 02-Nov-2004
 */
package com.apress.prospring.ch19.business;

import java.util.ArrayList;
import java.util.List;

import com.apress.prospring.ch19.domain.Product;


/**
 * @author janm
 */
public class StaticListProductManager implements ProductManager {

	private List<Product> products;
	
	/**
	 * Creates Product instance with all appropriate fields set
	 * 
	 * @param productId The productId
	 * @param name The name
	 * @param description The description
	 * @return Product instance
	 */
	private Product createProduct(int productId, String name, String description) {
		Product product = new Product();
		product.setProductId(productId);
		product.setName(name);
		product.setDescription(description);
		
		return product;
	}
	
	/**
	 * .ctor
	 */
	public StaticListProductManager() {
		products = new ArrayList<Product>();
		products.add(createProduct(1, "Pro Spring", "The best book ever"));
		products.add(createProduct(2, "Pro Jakarta Struts", "That's a good one, too"));
	}
	
	/* (non-Javadoc)
	 * @see com.apress.prospring.ch19.business.ProductManager#findAll()
	 */
	public List<Product> findAll() {
		return products;
	}

}
