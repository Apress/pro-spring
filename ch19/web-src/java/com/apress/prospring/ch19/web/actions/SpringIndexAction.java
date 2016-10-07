/*
 * Created on 04-Nov-2004
 */
package com.apress.prospring.ch19.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.apress.prospring.ch19.business.ProductManager;

/**
 * @author janm
 */
public class SpringIndexAction extends Action {

	private ProductManager productManager;

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("products", productManager.findAll());

		return mapping.findForward("success");
	}

	/**
	 * @param productManager The productManager to set.
	 */
	public final void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
