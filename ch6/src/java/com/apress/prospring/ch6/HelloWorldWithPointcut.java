/*
 * Created on Aug 11, 2004
 */
package com.apress.prospring.ch6;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;


/**
 * @author robh
 */
public class HelloWorldWithPointcut {

    public static void main(String[] args) {

        // get proxy
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(new SimpleBeforeAdvice()));
        
        pf.setTarget(new MessageWriter());
        MessageWriter proxy1 = (MessageWriter)pf.getProxy();
        
        pf.setTarget(new MessageWriter());
        MessageWriter proxy2 = (MessageWriter)pf.getProxy();
        proxy2.writeMessage();
        
        pf.setTarget(new ErrorBean());
        ErrorBean proxy3 = (ErrorBean)pf.getProxy();
        proxy3.hashCode();
        
    }
}
