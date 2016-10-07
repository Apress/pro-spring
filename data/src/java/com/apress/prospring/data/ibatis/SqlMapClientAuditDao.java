/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data.ibatis;

import java.util.Date;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.data.AuditDao;
import com.apress.prospring.domain.Audit;


/**
 * @author janm
 */
public class SqlMapClientAuditDao extends SqlMapClientDaoSupport implements AuditDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#getAll()
	 */
	public List getAll() {
		return getSqlMapClientTemplate().queryForList("getAllAudit", null);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#insert(com.apress.prospring.domain.Audit)
	 */
	public void insert(Audit audit) {
		getSqlMapClientTemplate().insert("insertAudit", audit);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#purge(java.util.Date)
	 */
	public void purge(Date oldestDate) {
		// TODO Auto-generated method stub

	}
}
