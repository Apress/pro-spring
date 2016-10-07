/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.pubsub;

import javax.jms.Destination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author robh
 */
public class Producer {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-pubsub.xml"

                });

        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        final Destination destination = (Destination) ctx.getBean("destination");

        for(int x = 0; x < 2; x++) {
            System.out.println("Sending Message: " + x);
            template.convertAndSend(destination, "Foo: " + x);
            Thread.sleep(400);
        }
    }
}