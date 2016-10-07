/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class AspectJExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch7/src/conf/aspectj.xml");
        MessageWriter writer = new MessageWriter();
        writer.writeMessage();
        writer.foo();
        
    }
}