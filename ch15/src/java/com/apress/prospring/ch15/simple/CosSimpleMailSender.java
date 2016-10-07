/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.simple;

import org.springframework.mail.MailSender;
import org.springframework.mail.cos.CosMailSenderImpl;

/**
 * @author robh
 */
public class CosSimpleMailSender extends SimpleMailSender {

    protected MailSender getMailSender() {
        CosMailSenderImpl sender = new CosMailSenderImpl();
        sender.setHost("post.demon.co.uk");
        return sender;
    }

    
}
