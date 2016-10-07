/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch4.inheritance;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class SimpleBean {

    public String name;

    public int age;
    

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/beans.xml"));
        
        SimpleBean parent = (SimpleBean)factory.getBean("inheritParent");
        SimpleBean child = (SimpleBean)factory.getBean("inheritChild");
        
        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
        
    public String toString() {
        return    "Name: " + name + "\n"
                + "Age:" + age;
    }
}