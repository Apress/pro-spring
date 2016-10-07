/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data;

import java.util.List;

import com.apress.prospring.domain.User;


/**
 * User DAO interface
 * 
 * @author janm
 */
public interface UserDao {

	/**
	 * Returns a User object identified by Username and Password
	 * 
	 * @param username The username
	 * @param password The password
	 * @return User object
	 */
	public User getByUsernameAndPassword(String username, String password);
	
	/**
	 * Saves a User
	 * 
	 * @param user User to be saved
	 */
	public void save(User user);
		
	/**
	 * Deletes an existing user
	 * 
	 * @param userId User identity to be deleted
	 */
	public void delete(int userId);

	/**
	 * Returns all Users
	 * 
	 * @return List of Users
	 */
	public List getAll();
}
