/*
 * Created on Sep 16, 2004
 */
package com.apress.prospring.business;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.apress.prospring.domain.Entry;
import com.apress.prospring.domain.User;

import junit.framework.TestCase;

/**
 * @author robh
 */
public class TransactionTest extends TestCase {

    private ApplicationContext getApplicationContext() {
        String[] paths = new String[] {
                "./business/src/resources/applicationContext-db.xml",
                "./business/src/resources/applicationContext.xml" };

        return new FileSystemXmlApplicationContext(paths);
    }

    public void testTransaction() {
        ApplicationContext ctx = getApplicationContext();
        DefaultBlogManager bm = (DefaultBlogManager) ctx.getBean("blogManager");
        bm.setAuditService(new MockAuditService());

        int countBefore = bm.getAllEntries().size();

        Entry e = new Entry();
        e.setSubject("Tester");
        e.setBody("Body");
        e.setPostDate(new Date());

        try {
            bm.saveEntry(e, null);
            fail("Should have thrown RuntimeException");
        } catch (RuntimeException ex) {

        }

        int countAfter = bm.getAllEntries().size();

        assertEquals("The new Entry should not have been added", countBefore,
                countAfter);

    }

    private static class MockAuditService implements AuditService {

        public void writeAuditMessage(String data, User user) {
            throw new RuntimeException("Foo!");
        }

        public void purgeAudit(Date oldestDate) {
            // no-op
        }

		/* (non-Javadoc)
		 * @see com.apress.prospring.business.AuditService#getAllAuditEntries()
		 */
		public List getAllAuditEntries() {
			// TODO Auto-generated method stub
			return null;
		}

    }
}