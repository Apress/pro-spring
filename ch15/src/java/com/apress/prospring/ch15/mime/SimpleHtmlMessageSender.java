/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.mime;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author robh
 *  
 */
public class SimpleHtmlMessageSender extends AbstractMessageSender {

	public void sendMessage() throws MessagingException {
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);

		helper.setTo(to);
		helper.setFrom(from);
		helper.setSubject(subject);
		helper.setText("<html><head></head><body><h1>Hello World!"
				+ "</h1></body></html>", true);

		sender.send(msg);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[] { "./ch15/src/conf/simpleHtmlMessageSender.xml",
						"./ch15/src/conf/javaMailSender.xml" });

		SimpleHtmlMessageSender sender = (SimpleHtmlMessageSender) ctx
				.getBean("messageSender");
		sender.sendMessage();
	}
}