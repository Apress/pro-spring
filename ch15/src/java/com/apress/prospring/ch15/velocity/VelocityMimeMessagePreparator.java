/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.velocity;

import java.util.Map;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author robh
 *  
 */
public class VelocityMimeMessagePreparator implements MimeMessagePreparator,
		InitializingBean {

	private VelocityEngine velocityEngine;

	private String plainTextTemplate = "plainText.vm";

	private String htmlTemplate = "html.vm";

	private String from;

	private String to;

	private String subject;

	private Map data;

	public void prepare(MimeMessage msg) throws Exception {
		// set header details
		msg.addFrom(InternetAddress.parse(from));
		msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		msg.setSubject(subject);

		// create wrapper multipart/alternative part
		MimeMultipart ma = new MimeMultipart("alternative");
		msg.setContent(ma);

		// create the plain text
		BodyPart plainText = new MimeBodyPart();
		plainText.setText(VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, plainTextTemplate, data));
		ma.addBodyPart(plainText);

		//  create the html part
		BodyPart html = new MimeBodyPart();
		html.setContent(VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, htmlTemplate, data), "text/html");
		ma.addBodyPart(html);
	}

	public void afterPropertiesSet() throws Exception {
		if (velocityEngine == null) {
			throw new IllegalArgumentException(
					"Must set the velocityEngine property of "
							+ getClass().getName());
		}
	}

	public void setPlainTextTemplatePath(String plainTextTemplate) {
		this.plainTextTemplate = plainTextTemplate;
	}

	public void setHtmlTemplatePath(String htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setData(Map data) {
		this.data = data;
	}

}