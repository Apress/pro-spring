/*
 * Created on 04-Aug-2004
 */
package com.apress.prospring.data.jdbc;


/**
 * @author janm
 */
public class JdbcMysqlAuditDao extends JdbcAbstractAuditDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.jdbc.JdbcAbstractAuditDao#getIdentitySql()
	 */
	protected String getIdentitySql() {
		return "select LAST_INSERT_ID()";
	}

}
