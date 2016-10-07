/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.data.UserDao;
import com.apress.prospring.domain.User;

/**
 * @author janm
 */
public class SqlMapClientUserDao extends SqlMapClientDaoSupport implements UserDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#getByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public User getByUsernameAndPassword(String username, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);

		return (User)getSqlMapClientTemplate().queryForObject("getUserByUsernameAndPassword", params);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#save(com.apress.prospring.domain.User)
	 */
	public void save(User user) {
		if (user.getUserId() == 0) 
			insert(user);
		else
			update(user);
	}

	/**
	 * Inserts a User
	 * 
	 * @param user The user
	 */
	private void insert(User user) {
		getSqlMapClientTemplate().insert("insertUser", user);
	}

	/**
	 * Updates a User
	 * 
	 * @param user The user
	 */
	private void update(User user) {
		getSqlMapClientTemplate().update("updateUser", user);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#delete(int)
	 */
	public void delete(int userId) {
		getSqlMapClientTemplate().delete("deleteUser", new Integer(userId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#getAll()
	 */
	public List getAll() {
		return getSqlMapClientTemplate().queryForList("getAllUsers", null);
	}

}