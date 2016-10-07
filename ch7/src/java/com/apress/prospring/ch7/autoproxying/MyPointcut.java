/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.autoproxying;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

/**
 * @author robh
 */
public class MyPointcut implements Pointcut {

  
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
          
            public boolean matches(Class cls) {
                return (cls == AutoBean.class);
            }
        };
    }

    public MethodMatcher getMethodMatcher() {
        return MethodMatcher.TRUE;
    }

}
