/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.mime;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author robh
 *  
 */
public class AttachmentMessageSender extends AbstractMessageSender {

	public void sendMessage() throws MessagingException {
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);
		helper.setFrom(from);
		helper.setSubject(subject);

		helper.setText(
				"<html><head></head><body><h1>Hello World!</h1></body></html>",
				true);

		// add the image
		FileSystemResource img = new FileSystemResource(new File(
				"./ch15/src/images/apress.gif"));
		helper.addAttachment("apress.gif", img);

		sender.send(msg);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[] { "./ch15/src/conf/attachmentMessageSender.xml",
						"./ch15/src/conf/javaMailSender.xml" });

		AttachmentMessageSender sender = (AttachmentMessageSender) ctx
				.getBean("messageSender");
		sender.sendMessage();
	}
}