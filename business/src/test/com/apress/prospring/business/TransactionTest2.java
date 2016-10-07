/*
 * Created on Sep 16, 2004
 */
package com.apress.prospring.business;

import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.apress.prospring.domain.Entry;
import com.apress.prospring.domain.User;

/**
 * @author janm
 */
public class TransactionTest2 extends AbstractDependencyInjectionSpringContextTests {

	private DefaultBlogManager blogManager;

	/* (non-Javadoc)
	 * @see org.springframework.test.AbstractSpringContextTests#loadContextLocations(java.lang.String[])
	 */
	protected ConfigurableApplicationContext loadContextLocations(String[] paths) {
		return new FileSystemXmlApplicationContext(paths);
	}

	public void testTransaction2() {
		blogManager.setAuditService(new MockAuditService());
		
		int countBefore = blogManager.getAllEntries().size();

		Entry e = new Entry();
		e.setSubject("Tester");
		e.setBody("Body");
		e.setPostDate(new Date());

		try {
			blogManager.saveEntry(e, null);
			fail("Should have thrown RuntimeException");
		} catch (RuntimeException ex) {

		}

		int countAfter = blogManager.getAllEntries().size();

		assertEquals("The new Entry should not have been added", countBefore, countAfter);

	}

	private static class MockAuditService implements AuditService {

		public void writeAuditMessage(String data, User user) {
			throw new RuntimeException("Foo!");
		}

		public void purgeAudit(Date oldestDate) {
			// no-op
		}

		public List getAllAuditEntries() {
			return null;
		}

	}

	/**
	 * @param blogManager The blogManager to set.
	 */
	public void setBlogManager(DefaultBlogManager blogManager) {
		this.blogManager = blogManager;
	}

	/* (non-Javadoc)
	 * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#getConfigLocations()
	 */
	protected String[] getConfigLocations() {
		return new String[] { "./business/src/resources/applicationContext-db.xml", "./business/src/resources/applicationContext.xml",
				"./business/src/resources/applicationContext-jdbc.xml"};
	}

}