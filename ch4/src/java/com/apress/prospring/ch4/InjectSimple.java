/*
 * Created on Jul 28, 2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class InjectSimple {

    private String name;

    private int age;

    private float height;

    private boolean isProgrammer;

    private Long ageInSeconds;

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/beans.xml"));
        InjectSimple simple = (InjectSimple)factory.getBean("injectSimple");
        factory.getBean("injectRef");
        System.out.println(simple);
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return    "Name :" + name + "\n"
                + "Age:" + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + isProgrammer;
    }
}