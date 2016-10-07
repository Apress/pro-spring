/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class AccessingFactoryBeans {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch5/src/conf/factory/factory.xml"));

        MessageDigest digest = (MessageDigest) factory
                .getBean("shaDigest");
       
        
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) factory
                .getBean("&shaDigest");
    }
}