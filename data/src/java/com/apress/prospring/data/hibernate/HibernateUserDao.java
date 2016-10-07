/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.hibernate;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.data.UserDao;
import com.apress.prospring.domain.User;


/**
 * @author janm
 */
public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#getByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public User getByUsernameAndPassword(String username, String password) {
		List users = getHibernateTemplate().findByNamedParam("select u from User as u where u.username=:username and u.password=:password", new String[] { "username", "password" },
				new Object[] { username, password });
		if (users.size() == 1) {
			return (User)users.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#insert(com.apress.prospring.domain.User)
	 */
	public void save(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#delete(int)
	 */
	public void delete(int userId) {
		User user = new User();
		user.setUserId(userId);
		getHibernateTemplate().delete(user);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#getAll()
	 */
	public List getAll() {
		return getHibernateTemplate().find("select u from User as u");
	}

}
