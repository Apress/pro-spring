/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.simple;

import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author robh
 */
public class JavaMailSimpleMailSender extends SimpleMailSender {


    protected MailSender getMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("post.demon.co.uk");
        return sender;
    }

}
