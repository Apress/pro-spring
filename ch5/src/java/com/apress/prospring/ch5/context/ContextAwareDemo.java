/*
 * Created on Aug 6, 2004
 */
package com.apress.prospring.ch5.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class ContextAwareDemo implements ApplicationContextAware {

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ctx = applicationContext;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch5/src/conf/appContext/aware.xml");
        
        ContextAwareDemo demo = (ContextAwareDemo) ctx.getBean("contextAware");
        demo.displayAppContext();
    }

    public void displayAppContext() {
        System.out.println(ctx);
    }
}