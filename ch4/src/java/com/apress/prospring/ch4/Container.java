/*
 * Created on Jul 27, 2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public interface Container {

    public Object getDependency(String key);
}
