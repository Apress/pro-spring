/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class HelloWorldJndiHost {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch16/src/conf/rmi/helloWorldJndi.xml");
        System.out.println("Host Started...");
    }
}
