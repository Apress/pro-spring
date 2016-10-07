/*
 * Created on Sep 6, 2004
 */
package com.apress.prospring.ch6.staticpc;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * @author robh
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    public boolean matches(Method method, Class cls) {
        return ("foo".equals(method.getName()));
    }

    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class cls) {
                return (cls == BeanOne.class);
            }
        };

    }
}