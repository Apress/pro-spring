/*
 * Created on Aug 24, 2004
 */
package com.apress.prospring.ch12;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring.ch12.business.AccountManager;
import com.apress.prospring.ch12.domain.Account;

/**
 * @author janm
 */
public class Main {
	
	private ApplicationContext context;
	
	private void run() {
		System.out.println("Initializing application");
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "applicationContext-local.xml" });
		AccountManager manager = (AccountManager)context.getBean("accountManager");
		
		int count = manager.count();
		int failures = 0;
		int attempts = 100;
		
		for (int i = 0; i < attempts; i++) {
			Account a = new Account();
			a.setBalance(new BigDecimal(10));
			a.setNumber("123 " + i);
			a.setSortCode("xxx " + i);
			try {
				manager.insert(a);
			} catch (RuntimeException ex) {
				System.out.println("Failed to insert account " + ex.getMessage());
				failures++;
			}
		}
		
		System.out.println("Attempts  : " + attempts);
		System.out.println("Failures  : " + failures);
		System.out.println("Prev count: " + count);
		System.out.println("New count : " + manager.count());
		
		System.out.println("Done");
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
