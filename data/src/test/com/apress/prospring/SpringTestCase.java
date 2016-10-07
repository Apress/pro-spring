/*
 * Created on 21-Jul-2004
 */
package com.apress.prospring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.TestCase;

/**
 * @author janm
 */
public class SpringTestCase extends TestCase {

	private ApplicationContext context;
	private static final String[] CONFIG_LOCATIONS = 
		new String[] { 
			"business/src/resources/applicationContext.xml",
			"business/src/resources/applicationContext-db.xml" };
	private Log log = LogFactory.getLog(getClass());

	/**
	 * Returns the Log
	 * 
	 * @return Log
	 */
	protected Log log() {
		return this.log;
	}
	
	/**
	 * Gets the ApplicationContext
	 * 
	 * @return ApplicationContext
	 */
	protected ApplicationContext context() {
		return this.context;
	}
	
	/**
	 * Returns bean from the context identified by its name
	 * 
	 * @param name Bean name
	 * @return The bean
	 */
	protected Object getBean(String name) {
		return context.getBean(name);
	}
	
	/**
	 * Creates new instance of SpringTestCase and builds application context
	 */
	public SpringTestCase() {
		context = new FileSystemXmlApplicationContext(CONFIG_LOCATIONS);
	}
}