/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.simple;

/**
 * @author robh
 */
public class SimpleMailTest {

	private static final String TO = "robh@cakesolutions.net";

	private static final String TEXT = "Hello World!";

	public static void main(String[] args) {

		SimpleMailSender sender1 = new JavaMailSimpleMailSender();
		SimpleMailSender sender2 = new CosSimpleMailSender();

		sender1.sendMessage(TO, TEXT);
		sender2.sendMessage(TO, TEXT);
	}
}