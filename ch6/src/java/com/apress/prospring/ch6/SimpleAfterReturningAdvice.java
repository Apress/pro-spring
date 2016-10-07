/*
 * Created on Aug 12, 2004
 */
package com.apress.prospring.ch6;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author robh
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        // create the proxy
        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        // write the messages
        proxy.writeMessage();
    }

    public void afterReturning(Object returnValue, Method method, Object[] args,
            Object target) throws Throwable {
        System.out.println("");
        System.out.println("After method: " + method.getName());
    }
}
