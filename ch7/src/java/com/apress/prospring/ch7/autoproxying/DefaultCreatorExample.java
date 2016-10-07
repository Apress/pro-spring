/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.autoproxying;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class DefaultCreatorExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch7/src/conf/dpac.xml");
        
        AutoBean autoBean = (AutoBean)ctx.getBean("autoBean");
        OtherBean otherBean = (OtherBean)ctx.getBean("otherBean");
        
        autoBean.foo();
        System.out.println(AopUtils.isAopProxy(autoBean));
        
        otherBean.foo();
        System.out.println(AopUtils.isAopProxy(otherBean));
    }
}
