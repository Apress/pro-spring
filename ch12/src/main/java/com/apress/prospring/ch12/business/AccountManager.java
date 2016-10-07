/*
 * Created on 15-Sep-2004
 */
package com.apress.prospring.ch12.business;

import java.math.BigDecimal;

import com.apress.prospring.ch12.domain.Account;


/**
 * @author janm
 */
public interface AccountManager {

	public void insert(Account account);
	
	public void deposit(int accountId, BigDecimal amount);
	
	public void transfer(int sourceAccount, int targetAccount, BigDecimal amount);

	public int count();
}
