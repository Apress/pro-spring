/*
 * Created on 27-Jul-2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.apress.prospring.ch2.MessageProvider;
import com.apress.prospring.ch2.MessageRenderer;

/**
 * @author robh
 */
public class HelloWorldXml {

    public static void main(String[] args) throws Exception {

        // get the bean factory
        BeanFactory factory = getBeanFactory();

        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        MessageProvider mp = (MessageProvider) factory.getBean("provider");

        mr.setMessageProvider(mp);
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {
        // get the bean factory
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "ch4/src/conf/beans.xml"));

        return factory;
    }
}