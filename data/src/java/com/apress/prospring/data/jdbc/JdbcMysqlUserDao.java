/*
 * Created on 28-Jul-2004
 */
package com.apress.prospring.data.jdbc;


/**
 * @author janm
 */
public class JdbcMysqlUserDao extends JdbcAbstractUserDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.jdbc.JdbcAbstractUserDao#getIdentitySql()
	 */
	protected String getIdentitySql() {
		return "select LAST_INSERT_ID()";
	}

}
