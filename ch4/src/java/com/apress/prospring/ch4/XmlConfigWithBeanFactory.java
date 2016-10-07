/*
 * Created on 27-Jul-2004
 */
package com.apress.prospring.ch4;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class XmlConfigWithBeanFactory {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "ch4/src/conf/beans.xml"));

    }
}