/*
 * Created on Aug 4, 2004
 */
package com.apress.prospring.ch5.interaction;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class LoggingBeanExample {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./ch5/src/conf/interaction/logging.xml"));
        
        LoggingBean bean = (LoggingBean)factory.getBean("loggingBean");
        bean.someOperation();
    }
}