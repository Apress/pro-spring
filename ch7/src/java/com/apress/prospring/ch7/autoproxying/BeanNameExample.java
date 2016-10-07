/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.autoproxying;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class BeanNameExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch7/src/conf/bnapc.xml");
        
        AutoBean fooBean = (AutoBean)ctx.getBean("fooBean");
        AutoBean barBean = (AutoBean)ctx.getBean("barBean");
        
        fooBean.foo();
        barBean.foo();
    }
}
