/*
 * Created on Jul 23, 2004
 */
package com.apress.prospring.ch2;

/**
 * @author robh
 */
public class HelloWorldDecoupled {

    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);        
        mr.render();
    }
}
