/*
 * Created on Aug 6, 2004
 */
package com.apress.prospring.ch5.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.apress.prospring.ch5.lifecycle.DestructiveBeanWithInterface;

/**
 * @author robh
 */
public class LazyInitDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch5/src/conf/appContext/lazy.xml");

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx
                .getBean("destructiveBean");
    }
}