/*
 * Created on Aug 4, 2004
 */
package com.apress.prospring.ch5.lifecycle;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author robh
 */
public class ShutdownHook implements Runnable {

    private ConfigurableListableBeanFactory factory;
    
    public ShutdownHook(ConfigurableListableBeanFactory factory) {
        this.factory = factory;
    }
    
    public void run() {
        System.out.println("Destroying Singletons");
        factory.destroySingletons();
        System.out.println("Singletons Destroyed");
    }
    
}
