/*
 * Created on 15-Sep-2004
 */
package com.apress.prospring.ch12.data;

import java.util.List;
import java.util.Random;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.ch12.domain.History;


/**
 * @author janm
 */
public class UnreliableSqlMapClientHistoryDao extends SqlMapClientDaoSupport implements HistoryDao {

	private Random r = new Random();
	
	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.HistoryDao#getByAccount(int)
	 */
	public List getByAccount(int account) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.HistoryDao#getById(int)
	 */
	public History getById(int historyId) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.HistoryDao#insert(com.apress.prospring.ch12.domain.History)
	 */
	public void insert(History history) {
		if (r.nextInt(100) % 3 == 0) {
			throw new RuntimeException("Foobar");
		}
		getSqlMapClientTemplate().insert("insertHistory", history);		
	}

}
