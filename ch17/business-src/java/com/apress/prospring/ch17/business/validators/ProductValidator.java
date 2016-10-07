/*
 * Created on Oct 24, 2004
 */
package com.apress.prospring.ch17.business.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.apress.prospring.ch17.domain.Product;

/**
 * @author janm
 */
public class ProductValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object obj, Errors errors) {
		Product product = (Product)obj;
		if (product.getName() == null || product.getName().length() == 0) { 
			errors.rejectValue("name", "required", "");
		}
	}

}