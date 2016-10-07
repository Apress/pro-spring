/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.introductions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class IntroductionConfigExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch7/src/conf/introductions.xml");

        TargetBean bean = (TargetBean) ctx.getBean("bean");
        IsModified mod = (IsModified) bean;

        // test interfaces
        System.out.println("Is TargetBean?: " + (bean instanceof TargetBean));
        System.out.println("Is IsModified?: " + (bean instanceof IsModified));

        // test is modified implementation
        System.out.println("Has been modified?: " + mod.isModified());
        bean.setName("Rob Harrop");
        System.out.println("Has been modified?: " + mod.isModified());
        bean.setName("Joe Schmoe");
        System.out.println("Has been modified?: " + mod.isModified());
    }
}