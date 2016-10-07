/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business;

/**
 * @author robh
 */
public interface ObscenityFilter {

    public boolean containsObscenities(String data);
    
    public String obfuscateObscenities(String data);
}
