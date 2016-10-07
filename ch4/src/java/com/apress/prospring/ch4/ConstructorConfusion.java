/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class ConstructorConfusion {

    private String someValue;

    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusion(int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/beans.xml"));

        ConstructorConfusion cc = (ConstructorConfusion) factory.getBean("constructorConfusion");
        System.out.println(cc);
    }

    public String toString() {
        return someValue;
    }
}