/*
 * Created on 27-Jul-2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class XmlConfig {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new FileSystemResource("ch4/src/conf/beans.xml"));
        Oracle oracle = (Oracle)factory.getBean("oracle");
    }
}
