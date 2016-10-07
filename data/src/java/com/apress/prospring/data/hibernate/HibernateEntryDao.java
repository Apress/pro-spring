/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.hibernate;

import java.sql.SQLException;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.springframework.orm.hibernate.HibernateCallback;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.data.EntryDao;
import com.apress.prospring.domain.Entry;

/** 
 * @author janm
 */
public class HibernateEntryDao extends HibernateDaoSupport implements EntryDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#getAll()
	 */
	public List getAll() {
		return getHibernateTemplate().find("select e from Entry");
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#save(com.apress.prospring.domain.Entry)
	 */
	public void save(Entry entry) {
		Entry ex = new Entry();
		ex.setEntryId(entry.getEntryId());
		ex.setBody(entry.getBody());
		ex.setEntryId(entry.getEntryId());
		ex.setPostDate(entry.getPostDate());
		ex.setSubject(entry.getSubject());
		getHibernateTemplate().saveOrUpdate(ex);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#delete(int)
	 */
	public void delete(int entryId) {
		Entry entry = new Entry();
		entry.setEntryId(entryId);
		getHibernateTemplate().delete(entry);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#getById(int)
	 */
	public Entry getById(int entryId) {
		return (Entry)getHibernateTemplate().load(Entry.class, new Integer(entryId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#getMostRecent(int)
	 */
	public List getMostRecent(final int count) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Entry");
				query.setMaxResults(count);
				return query.list();
			}
			
		});
	}

}