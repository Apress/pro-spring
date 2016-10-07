/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.trans;

import javax.jms.Message;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author robh
 */
public class TransactionDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-trans.xml"

                });

        Sender transactional = (Sender) ctx.getBean("sender");
        Sender nonTransactional = (Sender) ctx.getBean("senderTarget");

        System.out.println("Trying Transactional...");
        runTest(transactional, ctx);
        System.out.println("Trying Non Transactional...");
        runTest(nonTransactional, ctx);
    }

    private static void runTest(Sender sender, ApplicationContext ctx) {
        System.out.println("Got Transactional Proxy?: "
                + AopUtils.isAopProxy(sender));

        try {
            sender.sendMessages();
        } catch (Exception ex) {
            System.out.println("Sender Threw Exception");
        }

        // now try to receive messages
        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");

        // set timeout so that eventually
        // we stop trying to receive
        template.setReceiveTimeout(2000);

        Message msg = null;
        int count = 0;

        do {
            msg = template.receive(Sender.DESTINATION_NAME);

            if (msg != null)
                count++;

        } while (msg != null);

        System.out.println("Received " + count + " messages.");
    }
}