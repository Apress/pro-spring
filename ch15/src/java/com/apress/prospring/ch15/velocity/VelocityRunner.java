/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.velocity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author robh
 *  
 */
public class VelocityRunner {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[] { "./ch15/src/conf/velocity.xml",
						"./ch15/src/conf/javaMailSender.xml" });

		JavaMailSender sender = (JavaMailSender) ctx.getBean("sender");
		VelocityMimeMessagePreparator preparator = (VelocityMimeMessagePreparator) ctx
				.getBean("preparator");

		Map data = new HashMap();
		data.put("msg", "Hello World!");

		preparator.setData(data);

		sender.send(preparator);
	}
}