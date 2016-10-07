/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.jaxrpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.apress.prospring.ch16.remoting.MessageBean;

/**
 * @author robh
 */
public class MessageServiceClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch16/src/conf/jaxrpc/messageServiceClient.xml");
        MessageService service = (MessageService)ctx.getBean("messageService");
        MessageBean bean = service.getMessage();
        System.out.println(bean);
    }
}
