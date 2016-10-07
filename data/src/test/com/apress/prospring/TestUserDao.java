/*
 * Created on 08-Aug-2004
 */
package com.apress.prospring;

import com.apress.prospring.data.UserDao;
import com.apress.prospring.domain.User;


/**
 * @author janm
 */
public class TestUserDao extends SpringTestCase {
	private UserDao getDao() {
		return (UserDao)getBean("userDao");
	}
	
	public void testGetBean() {
		assertNotNull(getDao());
	}
	
	public void testGetAll() {
		User user = getDao().getByUsernameAndPassword("root", "pwd");
		log().debug(user);
		assertNotNull(user);
	}
}
