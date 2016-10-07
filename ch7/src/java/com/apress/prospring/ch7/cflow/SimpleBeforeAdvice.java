/*
 * Created on Sep 7, 2004
 */
package com.apress.prospring.ch7.cflow;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author robh
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {


    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("Before method: " + method);
    }

}
