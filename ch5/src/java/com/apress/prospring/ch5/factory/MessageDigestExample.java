/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class MessageDigestExample {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch5/src/conf/factory/factory.xml"));

        MessageDigester digester = (MessageDigester) factory
                .getBean("digester");
        digester.digest("Hello World!");

    }
}