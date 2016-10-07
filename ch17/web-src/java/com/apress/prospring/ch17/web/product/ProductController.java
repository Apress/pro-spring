/*
 * Created on 24-Sep-2004
 */
package com.apress.prospring.ch17.web.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.apress.prospring.ch17.domain.Product;

/**
 * @author janm
 */
public class ProductController extends MultiActionController {

	private List<Product> products;

	/**
	 * Creates new product with the appropriate properties set
	 * 
	 * @param productId The productId
	 * @param name The name
	 * @param expirationDate The expiration Date
	 * @return Product object with all properties set
	 */
	private Product createProduct(int productId, String name, Date expirationDate) {
		Product product = new Product();
		product.setProductId(productId);
		product.setName(name);
		product.setExpirationDate(expirationDate);
		
		return product;
	}
	
	/**
	 * .ctor
	 */
	public ProductController() {
		products = new ArrayList<Product>();
		Date today = new Date();
		products.add(createProduct(1, "test", today));
		products.add(createProduct(2, "Pro Spring Apress", today));
		products.add(createProduct(3, "Pro Velocity", today));
		products.add(createProduct(4, "Pro VS.NET", today));
	}
	
	/**
	 * Handles view
	 */
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.getOutputStream().print("Viewing product " + request.getParameter("productId"));

		return null;
	}

	/**
	 * Handles index
	 */
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("products-index", "products", products);
	}
	
}