/*
 * Created on Sep 7, 2004
 */
package com.apress.prospring.ch7.introductions;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author robh
 */
public class IntroductionExample {

    public static void main(String[] args) {
        // create the target
        TargetBean target = new TargetBean();
        target.setName("Rob Harrop");

        // create the advisor
        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);
        
        TargetBean proxy = (TargetBean)pf.getProxy();
        IsModified proxyInterface = (IsModified)proxy;
        
        // test interfaces
        System.out.println("Is TargetBean?: " + (proxy instanceof TargetBean));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        
        // test is modified implementation
        System.out.println("Has been modified?: " + proxyInterface.isModified());
        proxy.setName("Rob Harrop");
        System.out.println("Has been modified?: " + proxyInterface.isModified());
        proxy.setName("Joe Schmoe");
        System.out.println("Has been modified?: " + proxyInterface.isModified());
     
    }
}