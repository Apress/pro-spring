/*
 * Created on Sep 6, 2004
 */
package com.apress.prospring.ch6.proxies;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * @author robh
 */
public class TestPointcut extends StaticMethodMatcherPointcut {

    public boolean matches(Method method, Class cls) {
        return ("advised".equals(method.getName()));
    }

}
