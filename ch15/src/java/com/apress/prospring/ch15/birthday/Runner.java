/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.birthday;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class Runner {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"./ch15/src/conf/birthdayReminder.xml");
		System.in.read();
	}
}