/*
 * Created on Aug 24, 2004
 */
package com.apress.prospring.ch10;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring.ch10.data.CustomerDao;
import com.apress.prospring.ch10.data.OrderDao;
import com.apress.prospring.ch10.data.TestDao;
import com.apress.prospring.ch10.domain.Customer;
import com.apress.prospring.ch10.domain.Order;
import com.apress.prospring.ch10.domain.Test;


/**
 * @author janm
 */
public class Main {
	
	private ApplicationContext context;
	
	private void test() {
		System.out.println("Getting testDao");
		TestDao testDao = (TestDao)context.getBean("testDao");
		
		Date today = Calendar.getInstance().getTime();

		System.out.println("Inserting new Test record");
		Test test = new Test();
		test.setName("new one");
		test.setRunDate(today);
		testDao.save(test);
		
		System.out.println("Test inserted " + test);
		
		List tests = testDao.getAll();
		for (Iterator i = tests.iterator(); i.hasNext();) {
			test = (Test)i.next();
			System.out.println(test);
		}
		
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < 25000; i++) {
			testDao.getByNameAndRunDate("foo", today);
		}
		System.out.println("Took " + (System.currentTimeMillis() - startMillis) + " ms");
		
		startMillis = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			testDao.updateName(1, "foobar");
		}
		System.out.println("Took " + (System.currentTimeMillis() - startMillis) + " ms");		
	}
	
	private void customer() {
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		
		Customer janm = customerDao.getById(1);
		Customer robh = customerDao.getById(2);
		
		System.out.println(janm);
		System.out.println(robh);
	}
	
	private void order() {
		OrderDao orderDao = (OrderDao)context.getBean("orderDao");
		Order order = orderDao.getById(1);			
		System.out.println(order);
	}
	
	private void run() {
		System.out.println("Initializing application");
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		test();
		customer();
		order();
		
		System.out.println("Done");
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
