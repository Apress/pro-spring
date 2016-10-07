/*
 * Created on 28-Jul-2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class BeanNameAliasing {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./ch4/src/conf/beans.xml"));
        
        String s1 = (String)factory.getBean("name1");
        String s2 = (String)factory.getBean("name2");
        String s3 = (String)factory.getBean("name3");
        String s4 = (String)factory.getBean("name4");
        
        System.out.println((s1 == s2));
        System.out.println((s2 == s3));
        System.out.println((s3 == s4));
        
        String[] x = factory.getAliases("name3");
        System.out.println("");
    }
}
