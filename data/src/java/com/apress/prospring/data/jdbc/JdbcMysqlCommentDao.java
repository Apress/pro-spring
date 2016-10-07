/*
 * Created on 04-Aug-2004
 */
package com.apress.prospring.data.jdbc;


/**
 * @author janm
 */
public class JdbcMysqlCommentDao extends JdbcAbstractCommentDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.jdbc.JdbcAbstractCommentDao#getIdentitySql()
	 */
	protected String getIdentitySql() {
		return "select LAST_INSERT_ID()";
	}
}
