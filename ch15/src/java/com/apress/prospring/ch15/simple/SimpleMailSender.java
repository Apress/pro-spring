/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.simple;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author robh
 */
public abstract class SimpleMailSender {

    protected abstract MailSender getMailSender();
    
    public void sendMessage(String to, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("Test Message");
        msg.setFrom("test@apress.com");
        msg.setText(text);
        
        MailSender sender = getMailSender();
        sender.send(msg);
    }
    
}
