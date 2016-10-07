/*
 * Created on 07-Sep-2004
 */
package com.apress.prospring.ch12.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Account History
 * 
 * @author janm
 */
public class History {

	private int historyId;
	private int account;
	private String operation;
	private BigDecimal amount;
	private Date transactionDate;
	private Account targetAccount;

	// Operation

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	// Getters and Setters

	/**
	 * @return Returns the account.
	 */
	public int getAccount() {
		return account;
	}

	/**
	 * @param account The account to set.
	 */
	public void setAccount(int account) {
		this.account = account;
	}

	/**
	 * @return Returns the amount.
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount The amount to set.
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return Returns the historyId.
	 */
	public int getHistoryId() {
		return historyId;
	}

	/**
	 * @param historyId The historyId to set.
	 */
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	/**
	 * @return Returns the operation.
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation The operation to set.
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return Returns the targetAccount.
	 */
	public Account getTargetAccount() {
		return targetAccount;
	}

	/**
	 * @param targetAccount The targetAccount to set.
	 */
	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

	/**
	 * @return Returns the transactionDate.
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate The transactionDate to set.
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}