/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.mi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author robh
 */
public class BeanFactoryAwareLookupDemoBean implements BeanFactoryAware,
        DemoBean {

    private BeanFactory factory = null;

    public void setBeanFactory(BeanFactory factory) throws BeansException {
        this.factory = factory;
    }

    public MyHelper getMyHelper() {
        return (MyHelper) factory.getBean("helper");
    }

    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }

}