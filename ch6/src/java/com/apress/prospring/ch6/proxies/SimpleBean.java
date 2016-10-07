/*
 * Created on Sep 6, 2004
 */
package com.apress.prospring.ch6.proxies;

/**
 * @author robh
 */
public class SimpleBean implements ISimpleBean {

    private long dummy = 0;
    
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
