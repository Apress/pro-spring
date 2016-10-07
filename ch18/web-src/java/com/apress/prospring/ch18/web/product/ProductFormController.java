/*
 * Created on Oct 24, 2004
 */
package com.apress.prospring.ch18.web.product;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.RequestUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.apress.prospring.ch17.domain.Product;

/**
 * @author janm
 */
public class ProductFormController extends SimpleFormController {

	public ProductFormController() {
		super();
		setCommandClass(Product.class);
		setFormView("product-edit");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		System.out.println(command);

		return new ModelAndView("product-index-r");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, false));
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Product command = new Product();
		int productId = RequestUtils.getIntParameter(request, "productId", 0);
		if (productId != 0) {
			// load the product
			command.setProductId(productId);
			command.setName("loaded");
		}
		
		return command;
	}

}