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
public class HelloWorldClient {

    private HelloWorld helloWorldService;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch16/src/conf/rmi/helloWorldClient.xml");

        HelloWorldClient helloWorldClient = (HelloWorldClient) ctx
                .getBean("helloWorldClient");
        helloWorldClient.run();

    }

    public void run() {
        System.out.println(helloWorldService.getMessage());
    }

    public void setHelloWorldService(HelloWorld helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}