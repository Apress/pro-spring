/*
 * Created on Aug 4, 2004
 */
package com.apress.prospring.ch5.lifecycle;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class ShutdownHookExample {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(
                new FileSystemResource(
                        "./ch5/src/conf/lifecycle/disposeInterface.xml"));

        Runtime.getRuntime().addShutdownHook(
                new Thread(new ShutdownHook(factory)));
        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) factory.getBean("destructiveBean");
    }
}