/*
 * Created on 16-Sep-2004
 */
package com.apress.prospring.ch12.ejb;

import javax.jms.Message;

import org.springframework.ejb.support.AbstractJmsMessageDrivenBean;


/**
 * @author janm
 */
public class SpringMDB extends AbstractJmsMessageDrivenBean {
	
	/* (non-Javadoc)
	 * @see org.springframework.ejb.support.AbstractMessageDrivenBean#onEjbCreate()
	 */
	protected void onEjbCreate() {
		// noop
		
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		System.out.println("Message received");
	}
 
}
