/*
 * Created on Aug 6, 2004
 */
package com.apress.prospring.ch5.context;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class MessageSourceDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch5/src/conf/appContext/messageSource.xml");

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, czech));
        
        System.out.println(ctx.getMessage("nameMsg", new Object[] { "Rob",
                "Harrop" }, english));
    }
}