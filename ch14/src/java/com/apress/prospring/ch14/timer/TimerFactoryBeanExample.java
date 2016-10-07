/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class TimerFactoryBeanExample {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch14/src/conf/timer.xml");
        System.in.read();
    }
}