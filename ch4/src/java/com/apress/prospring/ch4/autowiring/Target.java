/*
 * Created on Jul 30, 2004
 */
package com.apress.prospring.ch4.autowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class Target {

    private Foo foo;
    private Foo foo2;
    
    private Bar bar;

    public Target() {
        
    }
    
    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }
    
    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }
    
    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }
    
    public void setFoo2(Foo foo) {
        this.foo2 = foo;
        System.out.println("Property foo2 set");
    }

    public void setMyBarProperty(Bar bar) {
        this.bar = bar;
        System.out.println("Property myBarProperty set");
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/autowiring.xml"));

        Target t = null;
        
        System.out.println("Using byName:\n");
        t = (Target) factory.getBean("targetByName");
        
        System.out.println("\nUsing byType:\n");
        t = (Target) factory.getBean("targetByType");
        
        System.out.println("\nUsing constructor:\n");
        t = (Target) factory.getBean("targetConstructor");
        
        System.out.println("\nUsing autodetect:\n");
        t = (Target) factory.getBean("targetAutodetect");
        
    }
}