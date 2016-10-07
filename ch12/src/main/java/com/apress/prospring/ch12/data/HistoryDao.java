/*
 * Created on 07-Sep-2004
 */
package com.apress.prospring.ch12.data;

import java.util.List;

import com.apress.prospring.ch12.domain.History;

/**
 * History DAO interface
 * 
 * @author janm
 */
public interface HistoryDao {
	
	/**
	 * Gets all History objects for the specified account
	 * 
	 * @param account Account to get histroy for
	 * @return List of History objects
	 */
	public List getByAccount(int account);
	
	/**
	 * Gets a History object identified by historyId
	 * 
	 * @param historyId History identity
	 * @return History object
	 */
	public History getById(int historyId);
	
	/**
	 * Inserts new History record
	 * 
	 * @param history History object to be inserted
	 */
	public void insert(History history);
}
