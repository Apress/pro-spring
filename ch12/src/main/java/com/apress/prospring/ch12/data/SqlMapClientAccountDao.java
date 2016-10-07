/*
 * Created on 07-Sep-2004
 */
package com.apress.prospring.ch12.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.ch12.domain.Account;

/**
 * iBATIS Implementation of AccountDao
 * 
 * @author janm
 */
public class SqlMapClientAccountDao extends SqlMapClientDaoSupport implements AccountDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.AccountDao#insert(com.apress.prospring.ch12.domain.Account)
	 */
	public void insert(Account account) {
		getSqlMapClientTemplate().insert("insertAccount", account);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.AccountDao#getById(int)
	 */
	public Account getById(int accountId) {
		return (Account)getSqlMapClientTemplate().queryForObject("getAccountById", new Integer(accountId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.AccountDao#getByNumberAndSortCode(java.lang.String, java.lang.String)
	 */
	public Account getByNumberAndSortCode(String number, String sortCode) {
		Map map = new HashMap();
		map.put("number", number);
		map.put("sortCode", sortCode);
		return (Account)getSqlMapClientTemplate().queryForObject("getAccountByNumberAndSortCode", map);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.AccountDao#updateBalance(int, java.math.BigDecimal)
	 */
	public void updateBalance(int accountId, BigDecimal delta) {
		Map map = new HashMap();
		map.put("accountId", new Integer(accountId));
		map.put("delta", delta);
		getSqlMapClientTemplate().update("updateAccountBalance", map);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.AccountDao#getCount()
	 */
	public int getCount() {
		return ((Integer)getSqlMapClientTemplate().queryForObject("getAccountCount", null)).intValue();
	}

}
