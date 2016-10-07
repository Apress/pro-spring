/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.asynch;

import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class Producer {

    private MessageProducer producer;
    private Session session;
    
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-asynch.xml"

                });
        
        Producer p = (Producer)ctx.getBean("messageProducer");
        p.createMessages();
        System.out.println("Done");
    }
    
    public void setMessageProducer(MessageProducer producer) {
        this.producer = producer;
    }
    
    public void setSession(Session session) {
        this.session = session;
    }
    
    public void createMessages() throws Exception{
        for(int x = 0; x < 10; x++) {
            Message m = session.createTextMessage("Foo " + x);
            producer.send(m);
            System.out.println("Sent Message: " + x);
        }
    }
}
