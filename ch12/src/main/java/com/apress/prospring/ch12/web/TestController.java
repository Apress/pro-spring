/*
 * Created on 16-Sep-2004
 */
package com.apress.prospring.ch12.web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.apress.prospring.ch12.business.AccountManager;
import com.apress.prospring.ch12.domain.Account;

/**
 * @author janm
 */
public class TestController implements InitializingBean, Controller {

	private AccountManager accountManager;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int count = accountManager.count();
		int failures = 0;
		int attempts = 100;
		for (int i = 0; i < attempts; i++) {
			Account account = new Account();
			account.setBalance(new BigDecimal(0));
			account.setNumber("" + System.currentTimeMillis());
			account.setSortCode("dfgdfg");
			try {
				accountManager.insert(account);
			} catch (Exception ex) {
				failures++;
			}
		}
		
		response.getWriter().println("<br>Attempts:  " + attempts);
		response.getWriter().println("<br>Commits:   " + (attempts - failures));
		response.getWriter().println("<br>Rollbacks: " + failures);
		response.getWriter().println("<hr>");
		response.getWriter().println("<br>Old count: " + count + ", new count " + accountManager.count());

		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		if (accountManager == null) 
			throw new BeanCreationException("Must set accountManager");
	}

	/**
	 * @param accountManager The accountManager to set.
	 */
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}