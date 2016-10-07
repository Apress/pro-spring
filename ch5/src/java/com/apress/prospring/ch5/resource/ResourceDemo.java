/*
 * Created on 07-Aug-2004
 */
package com.apress.prospring.ch5.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author robh
 */
public class ResourceDemo {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "./ch5/src/conf/events/events.xml");
  
        Resource res1 = ctx.getResource("file:///d:/tmp/test.txt");
        displayInfo(res1);
        Resource res2 = ctx.getResource("classpath:lib/commons-logging.jar");
        displayInfo(res2);
        Resource res3 = ctx.getResource("http://www.google.co.uk");
        displayInfo(res3);
    }
    
    private static void displayInfo(Resource res) throws Exception{
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
}
