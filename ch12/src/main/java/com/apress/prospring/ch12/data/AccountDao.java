/*
 * Created on 07-Sep-2004
 */
package com.apress.prospring.ch12.data;

import java.math.BigDecimal;

import com.apress.prospring.ch12.domain.Account;

/**
 * Account DAO interface
 * 
 * @author janm
 */
public interface AccountDao {
	
	/**
	 * Inserts a new account
	 * 
	 * @param account Account to be inserted
	 */
	public void insert(Account account);
	
	/**
	 * Gets an account identified by accountId
	 * 
	 * @param accountId Account identity
	 * @return Account object
	 */
	public Account getById(int accountId);
	
	/**
	 * Gets an account identified by number and sort code
	 * @param number Account number
	 * @param sortCode Account sort code
	 * @return Account object
	 */
	public Account getByNumberAndSortCode(String number, String sortCode);

	/**
	 * Updates account balance
	 * 
	 * @param accountId Account identity
	 * @param delta Balance delta
	 */
	public void updateBalance(int accountId, BigDecimal delta);
	
	/**
	 * Returns number of accounts
	 * 
	 * @return Number of records
	 */
	public int getCount();
}
