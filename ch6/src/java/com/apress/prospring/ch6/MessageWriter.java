/*
 * Created on Aug 11, 2004
 */
package com.apress.prospring.ch6;

/**
 * @author robh
 */
public class MessageWriter implements IMessageWriter{

    public void writeMessage() {
        System.out.print("World");
    }

}