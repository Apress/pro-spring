/*
 * Created on Aug 12, 2004
 */
package com.apress.prospring.ch6;

/**
 * @author robh
 */
public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bar");
    }
}