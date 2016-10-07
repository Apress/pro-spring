/*
 * Created on Oct 24, 2004
 */
package com.apress.prospring.ch17.web.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * @author janm
 */
public class ProductImageFormController extends SimpleFormController {

	public ProductImageFormController() {
		super();
		setCommandClass(ProductImageForm.class);
		setFormView("products-image");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		ProductImageForm form = (ProductImageForm)command;
		
		System.out.println(form.getName());
		byte[] contents = form.getContents();
		for (int i = 0; i < contents.length; i++) {
			System.out.print(contents[i]);
		}

		return new ModelAndView("products-index-r");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

}