/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.jndi;


/**
 * @author robh
 */
public class JndiObjectFactoryBeanMessageResolver implements MessageResolver {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}