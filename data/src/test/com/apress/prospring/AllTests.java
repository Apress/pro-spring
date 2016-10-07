/*
 * Created on 08-Aug-2004
 */
package com.apress.prospring;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * @author janm
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.apress.prospring");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestUserDao.class);
		suite.addTestSuite(TestEntryDao.class);
		suite.addTestSuite(TestCommentDao.class);
		suite.addTestSuite(TestAuditDao.class);
		//$JUnit-END$
		return suite;
	}
}
