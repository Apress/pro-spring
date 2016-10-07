/*
 * Created on 23-Jul-2004
 */
package com.apress.prospring.ch2;

/**
 * @author robh
 */
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {

        return "Hello World!";
    }

}