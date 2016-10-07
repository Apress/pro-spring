/*
 * Created on 15-Sep-2004
 */
package com.apress.prospring.ch12.business;

import java.math.BigDecimal;

import com.apress.prospring.ch12.domain.Account;

/**
 * @author janm
 */ 
public class DefaultAccountManager extends AbstractAccountManager {


	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#insert(com.apress.prospring.ch12.domain.Account)
	 */
	public void insert(Account account) {
		doInsert(account);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#deposit(int, java.math.BigDecimal)
	 */
	public void deposit(int accountId, BigDecimal amount) {
		doDeposit(accountId, amount);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#transfer(int, int, java.math.BigDecimal)
	 */
	public void transfer(int sourceAccount, int targetAccount, BigDecimal amount) {
		doTransfer(sourceAccount, targetAccount, amount);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#count()
	 */
	public int count() {
		return doCount();
	}
}