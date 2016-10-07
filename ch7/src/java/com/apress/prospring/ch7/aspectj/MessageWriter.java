/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.aspectj;

/**
 * @author robh
 */
public class MessageWriter {

    public void writeMessage() {
        System.out.println("foobar!");
    }
    
    public void foo() {
        System.out.println("foo");
    }
}
