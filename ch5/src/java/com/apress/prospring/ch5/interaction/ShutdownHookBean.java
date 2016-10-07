/*
 * Created on Aug 4, 2004
 */
package com.apress.prospring.ch5.interaction;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author robh
 */
public class ShutdownHookBean implements BeanFactoryAware,
        Runnable {

    private ConfigurableListableBeanFactory factory;

    public void setBeanFactory(BeanFactory factory) throws BeansException {

        if (factory instanceof ConfigurableListableBeanFactory) {
            this.factory = (ConfigurableListableBeanFactory) factory;
            Runtime.getRuntime().addShutdownHook(new Thread(this));
        }
    }

    public void run() {
        if (factory != null) {
            System.out.println("Destroying Singletons");
            factory.destroySingletons();
            System.out.println("Singletons Destroyed");
        }
    }

}