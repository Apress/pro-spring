/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.domain;

/**
 * @author janm
 */
public class User {

	/**
	 * ROOT user
	 */
	public static final User ROOT = new User(1, "root", "root", "jan@cakesolutions.net", 1);
	public static final User ANONYMOUS = new User(1, "anonymous", "anonymous", "anonymous@springblog.com", 1);

	private int userId;
	private String username;
	private String password;
	private String email;
	private int type;

	/**
	 * Creates new instance of this class
	 */
	public User() {

	}

	/**
	 * Creates new instance of User with all fields set
	 * 
	 * @param userId The userId
	 * @param username The username
	 * @param password The password
	 * @param email The email
	 * @param type The type
	 */
	private User(int userId, String username, String password, String email, int type) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof User) return ((User)obj).userId == userId;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return username;
	}

	/**
	 * @return Returns the userId.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return Returns the type.
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username The username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}