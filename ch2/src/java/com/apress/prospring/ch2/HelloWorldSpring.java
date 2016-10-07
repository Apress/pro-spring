/*
 * Created on Jul 23, 2004
 */
package com.apress.prospring.ch2;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * @author robh
 */
public class HelloWorldSpring {

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
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // create a definition reader
        PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(
                factory);

        // load the configuration options
        Properties props = new Properties();
        props.load(new FileInputStream("./ch2/src/conf/beans.properties"));

        rdr.registerBeanDefinitions(props);

        return factory;
    }
}