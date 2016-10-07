/*
 * Created on Jul 30, 2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class HierarchicalBeanFactoryUsage {

    public static void main(String[] args) {
        BeanFactory parent = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/parent.xml"));
        BeanFactory child = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/beans.xml"), parent);

        SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) child.getBean("target3");

        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());
    }
}