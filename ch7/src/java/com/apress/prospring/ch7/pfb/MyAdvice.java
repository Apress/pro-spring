/*
 * Created on Sep 8, 2004
 */
package com.apress.prospring.ch7.pfb;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author robh
 */
public class MyAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("Executing: " + method);
    }

}
