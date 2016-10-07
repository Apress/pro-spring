/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.helloworld;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author robh
 */
public class HelloWorldSender {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-helloWorld.xml"

                });

        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination destination = (Destination) ctx.getBean("destination");

        template.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Hello World");
            }
        });
        
        System.out.println("Message Sent");
    }
}