/*
 * Created on Sep 1, 2004
 */
package com.apress.prospring.ch9.data;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.ch9.domain.Test;


/**
 * @author janm
 */
public class HibernateTestDao extends HibernateDaoSupport implements TestDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.TestDao#getAll()
	 */
	public List getAll() {
		return getHibernateTemplate().find("from Test");
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.TestDao#getById(int)
	 */
	public Test getById(int testId) {
		return (Test)getHibernateTemplate().load(Test.class, new Integer(testId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.TestDao#save(com.apress.prospring.ch11.domain.Test)
	 */
	public void save(Test test) {
		getHibernateTemplate().saveOrUpdate(test);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.TestDao#delete(int)
	 */
	public void delete(int testId) {
		Test t = new Test();
		t.setTestId(testId);
		getHibernateTemplate().delete(t);
	}

}
