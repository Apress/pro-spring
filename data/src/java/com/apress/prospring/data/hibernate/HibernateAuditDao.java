/*
 * Created on 08-Nov-2004
 */
package com.apress.prospring.data.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.data.AuditDao;
import com.apress.prospring.domain.Audit;


/**
 * @author janm
 */
public class HibernateAuditDao extends HibernateDaoSupport implements AuditDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#getAll()
	 */
	public List getAll() {
		return getHibernateTemplate().find("select a from Audit as a");
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#insert(com.apress.prospring.domain.Audit)
	 */
	public void insert(Audit audit) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#purge(java.util.Date)
	 */
	public void purge(Date oldestDate) {
		// TODO Auto-generated method stub
		
	}

}
