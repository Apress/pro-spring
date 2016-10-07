/*
 * Created on Sep 6, 2004
 */
package com.apress.prospring.ch6.proxies;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author robh
 */
public class NoOpBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        // no-op
    }
}
