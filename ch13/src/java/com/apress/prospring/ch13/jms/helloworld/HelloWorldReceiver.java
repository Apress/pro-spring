/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.helloworld;

import javax.jms.Destination;
import javax.jms.Message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author robh
 */
public class HelloWorldReceiver {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-helloWorld.xml"

                });

        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination destination = (Destination) ctx.getBean("destination");

        System.out.println("Will wait " + template.getReceiveTimeout()
                + " seconds for message");

        Message msg = template.receive(destination);
        System.out.println("Received Message: " + msg);
    }
}