/*
 * Created on Sep 6, 2004
 */
package com.apress.prospring.ch6.namepc;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.apress.prospring.ch6.staticpc.SimpleAdvice;

/**
 * @author robh
 */
public class NamePointcutUsingAdvisor {

    public static void main(String[] args) {
        NameBean target = new NameBean();

        // create advisor
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(
                new SimpleAdvice());
        advisor.addMethodName("foo");
        advisor.addMethodName("bar");

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        NameBean proxy = (NameBean) pf.getProxy();

        proxy.foo();
        proxy.foo(999);
        proxy.bar();
        proxy.yup();
    }
}