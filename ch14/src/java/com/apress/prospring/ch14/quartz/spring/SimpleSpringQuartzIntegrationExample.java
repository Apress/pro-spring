/*
 * Created on Sep 29, 2004
 */
package com.apress.prospring.ch14.quartz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class SimpleSpringQuartzIntegrationExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch14/src/conf/quartzSimple.xml");
    }
}
