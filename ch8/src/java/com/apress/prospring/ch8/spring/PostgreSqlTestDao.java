/*
 * Created on Aug 14, 2004
 */
package com.apress.prospring.ch8.spring;

import com.apress.prospring.ch8.spring.JdbcAbstractTestDao;


/**
 * @author janm
 */
public class PostgreSqlTestDao extends JdbcAbstractTestDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.spring.JdbcAbstractTestDao#getIdentitySql()
	 */
	protected String getIdentitySql() {
		return "select last_value from test_testid_seq";
	}

}
