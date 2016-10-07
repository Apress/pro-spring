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
public class BeanNaming {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/beans.xml"));
        
        String s1 = (String)factory.getBean("string1");
        String s2 = (String)factory.getBean("string2");
        String s3 = (String)factory.getBean("java.lang.String");
    }
}