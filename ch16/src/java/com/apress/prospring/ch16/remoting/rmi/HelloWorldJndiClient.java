/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.apress.prospring.ch16.remoting.HelloWorld;

/**
 * @author robh
 */
public class HelloWorldJndiClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch16/src/conf/rmi/helloWorldJndiClient.xml");

        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldService");
        System.out.println(helloWorld.getMessage());

    }
}