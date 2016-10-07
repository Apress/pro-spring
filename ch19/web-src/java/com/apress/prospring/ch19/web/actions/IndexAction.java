/*
 * Created on 02-Nov-2004
 */
	package com.apress.prospring.ch19.web.actions;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import org.apache.struts.action.ActionForm;
	import org.apache.struts.action.ActionForward;
	import org.apache.struts.action.ActionMapping;
	import org.springframework.web.struts.ActionSupport;
	
	import com.apress.prospring.ch19.business.ProductManager;
	
/**
 * @author janm
 */
public class IndexAction extends ActionSupport {

	private ProductManager productManager;

	/* (non-Javadoc)
	 * @see org.springframework.web.struts.ActionSupport#onInit()
	 */
	protected void onInit() {
		productManager = (ProductManager)getWebApplicationContext().getBean("productManager");
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("products", productManager.findAll());

		return mapping.findForward("success");
	}
}
