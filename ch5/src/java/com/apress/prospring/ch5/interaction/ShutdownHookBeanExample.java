/*
 * Created on Aug 4, 2004
 */
package com.apress.prospring.ch5.interaction;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.apress.prospring.ch5.lifecycle.DestructiveBeanWithInterface;

/**
 * @author robh
 */
public class ShutdownHookBeanExample {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(
                new FileSystemResource(
                        "./ch5/src/conf/interaction/shutdownHook.xml"));

        // make sure the shutdown hook is created
        factory.preInstantiateSingletons();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) factory.getBean("destructiveBean");
    }
}