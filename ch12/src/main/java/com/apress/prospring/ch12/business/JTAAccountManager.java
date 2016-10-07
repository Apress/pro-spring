/*
 * Created on 16-Sep-2004
 */
package com.apress.prospring.ch12.business;

import java.math.BigDecimal;
import java.util.Random;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jms.core.JmsTemplate102;
import org.springframework.jms.core.MessageCreator;

import com.apress.prospring.ch12.domain.Account;

/**
 * @author janm
 */
public class JTAAccountManager extends AbstractAccountManager {

	private ConnectionFactory connectionFactory;
	private Queue queue;
	private JmsTemplate102 jmsTemplate;
	private Random random = new Random();

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AbstractAccountManager#initManager()
	 */
	protected void initManager() {
		if (connectionFactory == null) throw new BeanCreationException("Must set connectionFactory");
		if (queue == null) throw new BeanCreationException("Must set queue");
		jmsTemplate = new JmsTemplate102(connectionFactory, false);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.business.AccountManager#insert(com.apress.prospring.ch12.domain.Account)
	 */
	public void insert(Account account) {		
		doInsert(account);

		jmsTemplate.send(queue, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("foobar");
			}
			
		});

		if (random.nextInt(10) > 5) {
			System.out.println("Fail now");
			throw new IllegalArgumentException("fff");
		}
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

	/**
	 * @param connectionFactory The connectionFactory to set.
	 */
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	/**
	 * @param queue The queue to set.
	 */
	public void setQueue(Queue queue) {
		this.queue = queue;
	}	
}