/*
 * Created on 08-Aug-2004
 */
package com.apress.prospring;

import java.util.Date;
import java.util.List;

import com.apress.prospring.data.AuditDao;
import com.apress.prospring.domain.Audit;


/**
 * @author janm
 */
public class TestAuditDao extends SpringTestCase {

	private AuditDao getDao() {
		return (AuditDao)getBean("auditDao");
	}

	private int count() {
		return getDao().getAll().size();
	}
	
	public void testGetBean() {
		assertNotNull(getDao());
	}

	public void testGetAll() {
		List a = getDao().getAll();
		assertNotNull(a);
	}
	
	public void testInsert() {
		int count = count();
		
		Audit a = new Audit();
		a.setAuditDate(new Date());
		a.setData("Audit data");
		a.setUser(null);
		
		getDao().insert(a);
		assertTrue(a.getAuditId() > 0);
		
		assertEquals(count + 1, count());
	}
}
