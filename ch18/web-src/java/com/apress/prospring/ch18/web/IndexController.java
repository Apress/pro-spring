/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch18.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author janm
 */
public class IndexController extends AbstractController {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		setCacheSeconds(10);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Greeting", "Hello World");
		model.put("Server time", new Date());
		
		return new ModelAndView("index", model);
	}

}