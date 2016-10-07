/*
 * Created on Oct 13, 2004
 */
package com.apress.prospring.ch15.birthday;

import java.util.TimerTask;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author robh
 */
public class ReminderTask extends TimerTask {

    private SimpleMailMessage defaultMessage;
    private MailSender sender;
    private String who;
        
    public void setMailMessage(SimpleMailMessage defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
    
    public void setMailSender(MailSender sender) {
        this.sender = sender;
    }
    
    public void setWho(String who) {
        this.who = who;
    }

    public void run() {
        SimpleMailMessage msg = new SimpleMailMessage(defaultMessage);
        msg.setText("Remember! It is " + who + "'s birthday in 7 days.");
        sender.send(msg);
        System.out.println("Sent reminder for: " + who);
    }

}
