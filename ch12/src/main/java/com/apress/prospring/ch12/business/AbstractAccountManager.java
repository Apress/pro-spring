/*
 * Created on 16-Sep-2004
 */
package com.apress.prospring.ch12.business;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import com.apress.prospring.ch12.data.AccountDao;
import com.apress.prospring.ch12.data.HistoryDao;
import com.apress.prospring.ch12.domain.Account;
import com.apress.prospring.ch12.domain.History;

/**
 * @author janm
 */
public abstract class AbstractAccountManager implements InitializingBean, AccountManager {

	private AccountDao accountDao;
	private HistoryDao historyDao;

	protected void doInsert(Account account) {
		getAccountDao().insert(account);
		History history = new History();
		history.setAccount(account.getAccountId());
		history.setAmount(account.getBalance());
		history.setOperation("Initial deposit");
		history.setTargetAccount(null);
		history.setTransactionDate(new Date());
		getHistoryDao().insert(history);
	}

	protected void doDeposit(int accountId, BigDecimal amount) {
		History history = new History();
		history.setAccount(accountId);
		history.setAmount(amount);
		history.setOperation("Deposit");
		history.setTargetAccount(null);
		history.setTransactionDate(new Date());

		getAccountDao().updateBalance(accountId, amount);
		getHistoryDao().insert(history);
	}

	protected void doTransfer(int sourceAccount, int targetAccount, BigDecimal amount) {
		Account source = getAccountDao().getById(sourceAccount);
		Account target = getAccountDao().getById(targetAccount);

		if (source.getBalance().compareTo(amount) > 0) {
			// transfer allowed
			getAccountDao().updateBalance(sourceAccount, amount.negate());
			getAccountDao().updateBalance(targetAccount, amount);

			History history = new History();
			history.setAccount(sourceAccount);
			history.setAmount(amount);
			history.setOperation("Paid out");
			history.setTargetAccount(target);
			history.setTransactionDate(new Date());
			getHistoryDao().insert(history);

			history = new History();
			history.setAccount(targetAccount);
			history.setAmount(amount);
			history.setOperation("Paid in");
			history.setTargetAccount(source);
			history.setTransactionDate(new Date());
			getHistoryDao().insert(history);
		} else {
			throw new RuntimeException("Not enough money");
		}
	}

	protected int doCount() {
		return getAccountDao().getCount();
	}	
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public final void afterPropertiesSet() throws Exception {
		if (accountDao == null) throw new BeanCreationException("Must set accountDao");
		if (historyDao == null) throw new BeanCreationException("Must set historyDao");
		initManager();
	}
	
	/**
	 * Override this method to perform extra initialization
	 */
	protected void initManager() {
		
	}

	/**
	 * @return Returns the accountDao.
	 */
	protected AccountDao getAccountDao() {
		return accountDao;
	}

	/**
	 * @param accountDao The accountDao to set.
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * @return Returns the historyDao.
	 */
	protected HistoryDao getHistoryDao() {
		return historyDao;
	}

	/**
	 * @param historyDao The historyDao to set.
	 */
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
}