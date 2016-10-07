/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch8;

import java.util.Iterator;
import java.util.List;

import com.apress.prospring.ch8.plain.PlainTestDao;

/**
 * Main testing class
 * 
 * @author janm
 */
public class Main {

	/**
	 * Main code
	 */
	private void run() {
		TestDao testDao = new PlainTestDao();
		
		List l = testDao.getAll();
		for (Iterator i = l.iterator(); i.hasNext();) {
			System.out.println(i.next());
		}
	}

	/**
	 * Main entry point
	 * @param args The args
	 */
	public static void main(String[] args) {
		new Main().run();
	}
}
