/*
 * Created on 07-Sep-2004
 */
package com.apress.prospring.ch12.domain;

import java.math.BigDecimal;

/**
 * Account
 * 
 * @author janm
 */
public class Account {

	private int accountId;
	private String number;
	private String sortCode;
	private BigDecimal balance;

	// Operations

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	// Getters and setters

	/**
	 * @return Returns the accountId.
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId The accountId to set.
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return Returns the balance.
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance The balance to set.
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return Returns the number.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number The number to set.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return Returns the sortCode.
	 */
	public String getSortCode() {
		return sortCode;
	}

	/**
	 * @param sortCode The sortCode to set.
	 */
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
}