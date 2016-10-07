/*
 * Created on Jul 30, 2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class NonSingleton {

    public static void main(String[] args) {

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/beans.xml"));
        
        String s1 = (String)factory.getBean("nonSingleton");
        String s2 = (String)factory.getBean("nonSingleton");
        
        System.out.println("Identity Equal?: " + (s1 ==s2));
        System.out.println("Value Equal:? " + s1.equals(s2));
        System.out.println(s1);
        System.out.println(s2);
    }
}