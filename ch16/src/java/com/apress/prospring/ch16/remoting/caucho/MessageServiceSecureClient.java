/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.caucho;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.apress.prospring.ch16.remoting.MessageService;

/**
 * @author robh
 *  
 */
public class MessageServiceSecureClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch16/src/conf/caucho/messageServiceSecure.xml");

        MessageService messageService = (MessageService) ctx
                .getBean("messageService");
        System.out.println(messageService.getMessage());
    }
}
