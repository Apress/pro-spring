/*
 * Created on Sep 6, 2004
 */
package com.apress.prospring.ch6.staticpc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author robh
 */
public class SimpleAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(">> Invoking " + invocation.getMethod().getName());
        Object retVal = invocation.proceed();
        System.out.println(">> Done");
        return retVal;
    }

}
