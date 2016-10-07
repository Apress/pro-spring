/*
 * Created on Aug 4, 2004
 */
package com.apress.prospring.ch5.lifecycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author robh
 */
public class DestructiveBeanWithInterface implements InitializingBean,
        DisposableBean {

    private InputStream is = null;

    public String filePath = null;

    public void afterPropertiesSet() throws Exception {

        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + DestructiveBean.class);
        }

        is = new FileInputStream(filePath);
    }

    public void destroy() {

        System.out.println("Destroying Bean");

        if (is != null) {
            try {
                is.close();
                is = null;
            } catch (IOException ex) {
                System.err.println("WARN: An IOException occured"
                        + " trying to close the InputStream");
            }
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(
                new FileSystemResource(
                        "./ch5/src/conf/lifecycle/disposeInterface.xml"));

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) factory.getBean("destructiveBean");

        System.out.println("Calling destroySingletons()");
        factory.destroySingletons();
        System.out.println("Called destroySingletons()");

    }

}