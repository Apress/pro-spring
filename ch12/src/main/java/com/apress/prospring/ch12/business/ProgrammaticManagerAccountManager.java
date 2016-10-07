/*
 * Created on 16-Sep-2004
 */
package com.apress.prospring.ch12.business;

import java.math.BigDecimal;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.apress.prospring.ch12.domain.Account;

/**
 * @author janm
 */
public class ProgrammaticManagerAccountManager extends AbstractAccountManager {

	private PlatformTransactionManager transactionManager;

	private TransactionDefinition getDefinition(int isolationLevel) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		def.setIsolationLevel(isolationLevel);
		
		return def;
	}
	
	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#insert(com.apress.prospring.ch12.domain.Account)
	 */
	public void insert(final Account account) {
		TransactionStatus status = transactionManager.getTransaction(getDefinition(TransactionDefinition.ISOLATION_READ_COMMITTED));
		try {
			doInsert(account);
			transactionManager.commit(status);
		} catch (Throwable t) {
			transactionManager.rollback(status);
		}

	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#deposit(int, java.math.BigDecimal)
	 */
	public void deposit(final int accountId, final BigDecimal amount) {
		TransactionStatus status = transactionManager.getTransaction(getDefinition(TransactionDefinition.ISOLATION_READ_COMMITTED));
		try {
			doDeposit(accountId, amount);
			transactionManager.commit(status);
		} catch (Throwable t) {
			transactionManager.rollback(status);
		}
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#transfer(int, int, java.math.BigDecimal)
	 */
	public void transfer(final int sourceAccount, final int targetAccount, final BigDecimal amount) {
		TransactionStatus status = transactionManager.getTransaction(getDefinition(TransactionDefinition.ISOLATION_READ_COMMITTED));
		try {
			doTransfer(sourceAccount, targetAccount, amount);
			transactionManager.commit(status);
		} catch (Throwable t) {
			transactionManager.rollback(status);
		}
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#count()
	 */
	public int count() {
		return doCount();
	}

	/**
	 * @param transactionManager The transactionManager to set.
	 */
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}