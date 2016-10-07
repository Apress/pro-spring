/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.asynch;

import javax.jms.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class Consumer{

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                new String[] { "./ch13/src/conf/applicationContext-common.xml",
                        "./ch13/src/conf/applicationContext-asynch.xml"

                });
        
        Connection connection = (Connection)ctx.getBean("connection");
        connection.start();
        
        System.out.println("Started");
        System.in.read();
    }
}
