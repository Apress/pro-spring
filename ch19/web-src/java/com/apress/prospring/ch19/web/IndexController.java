/*
 * Created on 06-Nov-2004
 */
package com.apress.prospring.ch19.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.apress.prospring.ch19.business.ProductManager;

/**
 * @author janm
 */
public class IndexController extends MultiActionController {

	private ProductManager productManager;

	public ModelAndView handleIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products", productManager.findAll());
		model.put("fromStruts", request.getAttribute("fromStruts"));
		
		return new ModelAndView("index", model);
	}

	/**
	 * @param productManager The productManager to set.
	 */
	public final void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
