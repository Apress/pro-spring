/*
 * Created on 12-Aug-2004
 */
package com.apress.prospring.ch6.security;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author robh
 */
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException(
                    "You must login before attempting to invoke the method: "
                            + method.getName());
        } else if ("robh".equals(user.getUserName())) {
            System.out.println("Logged in user is robh - OKAY!");
        } else {
            System.out.println("Logged in user is " + user.getUserName()
                    + " NOT GOOD :(");
            throw new SecurityException("User " + user.getUserName()
                    + " is not allowed access to method " + method.getName());
        }

    }
}