/*
 * Created on 16-Sep-2004
 */
package com.apress.prospring.ch12.business;

import java.math.BigDecimal;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.apress.prospring.ch12.domain.Account;

/**
 * @author janm
 */
public class ProgrammaticTemplateAccountManager extends AbstractAccountManager {

	private PlatformTransactionManager transactionManager;
	private TransactionTemplate transactionTemplate;

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AbstractAccountManager#initManager()
	 */
	protected void initManager() {
		super.initManager();
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#insert(com.apress.prospring.ch12.domain.Account)
	 */
	public void insert(final Account account) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			protected void doInTransactionWithoutResult(TransactionStatus status) {
				doInsert(account);
			}

		});
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#deposit(int, java.math.BigDecimal)
	 */
	public void deposit(final int accountId, final BigDecimal amount) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			protected void doInTransactionWithoutResult(TransactionStatus status) {
				doDeposit(accountId, amount);
			}

		});
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#transfer(int, int, java.math.BigDecimal)
	 */
	public void transfer(final int sourceAccount, final int targetAccount, final BigDecimal amount) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			protected void doInTransactionWithoutResult(TransactionStatus status) {
				doTransfer(sourceAccount, targetAccount, amount);
			}

		});
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#count()
	 */
	public int count() {
		return doCount();
	}

	/**
	 * @param platformTransactionManager The platformTransactionManager to set.
	 */
	public void setTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.transactionManager = platformTransactionManager;
	}
}