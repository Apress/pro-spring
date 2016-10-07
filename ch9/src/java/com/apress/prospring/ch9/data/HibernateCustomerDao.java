/*
 * Created on 02-Sep-2004
 */
package com.apress.prospring.ch9.data;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.ch9.domain.Customer;

/**
 * @author janm
 */
public class HibernateCustomerDao extends HibernateDaoSupport implements CustomerDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.CustomerDao#getAll()
	 */
	public List getAll() {
		return getHibernateTemplate().find("from Customer");
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.CustomerDao#save(com.apress.prospring.ch11.domain.Customer)
	 */
	public void save(Customer customer) {
		getHibernateTemplate().saveOrUpdate(customer);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch11.data.CustomerDao#getAllWithOnlyOnePermission()
	 */
	public List getAllWithOnlyOnePermission() {
		return getHibernateTemplate().find(
				"from Customer as c having c.permissions.size = ?",
				new Object[] { new Integer(1) });
	}

}
