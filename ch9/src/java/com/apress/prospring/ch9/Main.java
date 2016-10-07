/*
 * Created on Aug 24, 2004
 */
package com.apress.prospring.ch9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring.ch9.data.CustomerDao;
import com.apress.prospring.ch9.data.TestDao;
import com.apress.prospring.ch9.domain.Customer;
import com.apress.prospring.ch9.domain.CustomerAddress;
import com.apress.prospring.ch9.domain.Permission;
import com.apress.prospring.ch9.domain.Test;

/**
 * @author janm
 */
public class Main {
	
	private ApplicationContext context;
		
	private void test() {
		TestDao testDao = (TestDao)context.getBean("testDao");
		List tests = testDao.getAll();
		for (Iterator i = tests.iterator(); i.hasNext();) {
			Test test = (Test)i.next();
			System.out.println(test);
		}
		
		Test test1, test2;
		test1 = testDao.getById(1);
		test2 = testDao.getById(1);
		test1.setName("new Name");
		test2.setName("other name");
		testDao.save(test1);
		testDao.save(test2);
	}
	
	public void customer() {
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		List customers = customerDao.getAll();
		for (Iterator i = customers.iterator(); i.hasNext();) {
			Customer customer = (Customer)i.next();
			System.out.println(customer);
		}
		
		customers = customerDao.getAllWithOnlyOnePermission();
		for (Iterator i = customers.iterator(); i.hasNext();) {
			Customer customer = (Customer)i.next();
			System.out.println(customer);
		}		
		
		Customer customer = new Customer();
		customer.setFirstName("Jack");
		customer.setLastName("Schitt");
		customer.setPermissions(new HashSet());
		customer.setAddresses(new HashSet());
		
		CustomerAddress ca = new CustomerAddress();
		ca.setLine1("1");
		ca.setLine2("2");
		ca.setCity("Manchester");
		ca.setPostCode("M1 xx");
		
		customer.getAddresses().add(ca);
		
		Permission p = new Permission();
		p.setPermissionId(1);
		
		customer.getPermissions().add(p);
		
		//customerDao.save(customer);
	}
	
	private void run() {
		System.out.println("Initializing application");
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		test();
		customer();
		
		System.out.println("Done");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().run();
	}

}
