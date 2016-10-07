/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data.jdbc;

/**
 * Attachment DAO JDBC implementation
 * 
 * @author janm
 */
public class JdbcMysqlAttachmentDao extends JdbcAbstractAttachmentDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.jdbc.JdbcAbstractAttachmentDao#getIdentitySql()
	 */
	protected String getIdentitySql() {
		return "select LAST_INSERT_ID()";
	}
	
	
}
