/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.timer.bday;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class BirthdayScheduler {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch14/src/conf/timerBirthday.xml");
        System.in.read();
    }
}
