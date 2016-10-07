/*
 * Created on Jul 30, 2004
 */
package com.apress.prospring.ch4.depcheck;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class SimpleBean {

    private int someInt;

    private SimpleBean nestedSimpleBean;

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public void setNestedSimpleBean(SimpleBean nestedSimpleBean) {
        this.nestedSimpleBean = nestedSimpleBean;
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch4/src/conf/depcheck.xml"));
        
        SimpleBean simpleBean1 = (SimpleBean)factory.getBean("simpleBean1");
        SimpleBean simpleBean2 = (SimpleBean)factory.getBean("simpleBean2");
        SimpleBean simpleBean3 = (SimpleBean)factory.getBean("simpleBean3");
    }
}