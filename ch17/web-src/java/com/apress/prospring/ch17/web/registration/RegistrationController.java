/*
 * Created on 10-Nov-2004
 */
package com.apress.prospring.ch17.web.registration;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.apress.prospring.ch17.domain.Product;

/**
 * @author janm
 */
public class RegistrationController extends AbstractWizardFormController {

	public RegistrationController() {
		setPages(new String[] { "registration-step1", "registration-step2", "registration-finish"});
		setSessionForm(true);
		setCommandClass(Product.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractWizardFormController#processFinish(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		Product product = (Product) command;

		System.out.println("Register " + product);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractWizardFormController#processCancel(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		return super.processCancel(request, response, command, errors);
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
	 * @see org.springframework.web.servlet.mvc.AbstractWizardFormController#validatePage(java.lang.Object, org.springframework.validation.Errors, int, boolean)
	 */
	protected void validatePage(Object command, Errors errors, int page, boolean finish) {
		getValidator().validate(command, errors);
	}
}
