/*
 * Created on Aug 11, 2004
 */
package com.apress.prospring.ch6;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author robh
 */
public class HelloWorldAOPExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        
        // create the proxy
        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);


        MessageWriter proxy = (MessageWriter) pf.getProxy();
        
        // write the messages
        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }
}