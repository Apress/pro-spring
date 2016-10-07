/*
 * Created on Jul 30, 2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public class Singleton {

    private static Singleton instance;
    
    static {
        instance = new Singleton();
    }
    
    public static Singleton getInstance() {
        return instance;
    }
}
