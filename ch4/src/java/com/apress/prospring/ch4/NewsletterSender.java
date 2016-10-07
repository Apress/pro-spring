/*
 * Created on Jul 28, 2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public interface NewsletterSender {

    public void setSmtpServer(String smtpServer);
    public String getSmtpServer();
    
    public void setFromAddress(String fromAddress);
    public String getFromAddress();
    
    public void send();
}
