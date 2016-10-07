/*
 * Created on 07-Sep-2004
 */
package com.apress.prospring.ch12.data;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.ch12.domain.History;


/**
 * @author janm
 */
public class SqlMapClientHistoryDao extends SqlMapClientDaoSupport implements HistoryDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.HistoryDao#getByAccount(int)
	 */
	public List getByAccount(int account) {
		return getSqlMapClientTemplate().queryForList("getHistoryByAccount", new Integer(account));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.HistoryDao#getById(int)
	 */
	public History getById(int historyId) {
		return (History)getSqlMapClientTemplate().queryForObject("getHistoryById", new Integer(historyId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.HistoryDao#insert(com.apress.prospring.ch12.domain.History)
	 */
	public void insert(History history) {
		getSqlMapClientTemplate().insert("insertHistory", history);
	}

}
