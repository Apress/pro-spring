/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.mime;

import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author robh
 *
 */
public abstract class AbstractMessageSender {

	protected String to;
	protected String from;
	protected String subject;
	protected JavaMailSender sender;
	
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
		
	public void setJavaMailSender(JavaMailSender sender) {
		this.sender = sender;
	}
}
