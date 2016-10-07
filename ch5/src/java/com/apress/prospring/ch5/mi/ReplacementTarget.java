/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.mi;

/**
 * @author robh
 */
public class ReplacementTarget {

    public String formatMessage(String msg) {
        return "<h1>" + msg + "</h1>";
    }
    
    public String formatMessage(Object msg) {
        return "<h1>" + msg + "</h1>";
    }
    
    public void foo() {
        
    }
}
