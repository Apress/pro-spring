/*
 * Created on 08-Aug-2004
 */
package com.apress.prospring;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.apress.prospring.data.EntryDao;
import com.apress.prospring.domain.Entry;


/**
 * @author janm
 */
public class TestEntryDao extends SpringTestCase {

	private EntryDao getDao() {
		return (EntryDao)getBean("entryDao");
	}

	/**
	 * Returns number of records in database
	 * 
	 * @return The count
	 */
	private int count() {
		return getDao().getAll().size();
	}
	
	/**
	 * Test get bean
	 *
	 */
	public void testGetBean() {
		assertNotNull(getDao());
	}
	
	/**
	 * Tests getAll method
	 *
	 */
	public void testGetAll() {
		List entries = getDao().getAll();
		assertNotNull(entries);
		for (Iterator i = entries.iterator(); i.hasNext();) {
			Entry e = (Entry)i.next();
			assertNotNull(e);
		}
	}
	
	/**
	 * Tests insert and delete
	 *
	 */
	public void testInsertDelete() {
		int all = count();
		Entry e = new Entry();
		e.setBody("body");
		e.setPostDate(new Date());
		e.setSubject("subject");
		
		getDao().save(e);
		assertEquals(all + 1, count());
		assertTrue(e.getEntryId() > 0);
		
		getDao().delete(e.getEntryId());
		
		assertEquals(all, count());
	}
	
	/**
	 * Tests insert, update and delete
	 *
	 */
	public void testIUD() {
		Entry e = new Entry();
		e.setBody("body");
		e.setPostDate(new Date());
		e.setSubject("subject");
		
		getDao().save(e);
		assertTrue(e.getEntryId() > 0);
		
		Entry e2 = getDao().getById(e.getEntryId());
		assertEquals(e.getEntryId(), e2.getEntryId());
		assertEquals(e.getBody(), e2.getBody());
		assertEquals(e.getSubject(), e2.getSubject());
		assertEquals(e.getPostDate().getTime(), e2.getPostDate().getTime(), 1000);
		
		Date newDate = new Date(e.getPostDate().getTime() - 1000);
		e2.setSubject("foo");
		e2.setBody("bar");
		e2.setPostDate(newDate);
		
		getDao().save(e2);
		
		Entry e3 = getDao().getById(e2.getEntryId());
		assertEquals(e.getEntryId(), e3.getEntryId());
		assertEquals("bar", e3.getBody());
		assertEquals("foo", e3.getSubject());
		assertEquals(newDate.getTime(), e3.getPostDate().getTime(), 1000);

		getDao().delete(e3.getEntryId());
	}
	
	public void testGetMostRecent() {
		List entries = getDao().getMostRecent(100);
		assertNotNull(entries);
		assertTrue(entries.size() <= 100);
	}
}
