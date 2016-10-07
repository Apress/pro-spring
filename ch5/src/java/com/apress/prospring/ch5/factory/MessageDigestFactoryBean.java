/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author robh
 */
public class MessageDigestFactoryBean implements FactoryBean, InitializingBean {

    private String algorithmName = "MD5";
    
    private MessageDigest messageDigest = null;

    public Object getObject() throws Exception {
       return messageDigest;
    }


    public Class getObjectType() {
       return MessageDigest.class;
    }


    public boolean isSingleton() {
       return true;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }
    
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

}
