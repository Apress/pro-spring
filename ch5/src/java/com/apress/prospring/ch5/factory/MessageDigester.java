/*
 * Created on Aug 5, 2004
 */
package com.apress.prospring.ch5.factory;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * @author robh
 */
public class MessageDigester {

    private MessageDigest digest1 = null;
    private MessageDigest digest2 = null;
    
    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }
    
    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }
    
    public void digest(String msg) {
        System.out.println("Using digest1");
        digest(msg, digest1);

        System.out.println("Using digest2");
        digest(msg, digest2);
    }
    
    private void digest(String msg, MessageDigest digest) {
        System.out.println("Using alogrithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        BASE64Encoder enc = new BASE64Encoder();
        System.out.println(enc.encode(out));
    }
}
