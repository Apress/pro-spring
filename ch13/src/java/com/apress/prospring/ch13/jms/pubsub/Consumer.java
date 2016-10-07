/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.pubsub;

import javax.jms.Destination;
import javax.jms.Message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author robh
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-pubsub.xml"

                });

        System.out.println("Starting Consumer");

        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        final Destination destination = (Destination) ctx
                .getBean("destination");

        while (true) {
            System.out.println("Waiting...");
            Message msg = template.receive(destination);
            System.out.println("Received: " + msg);
        }
    }
}