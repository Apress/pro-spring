/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.ejb;

import java.io.Serializable;

/**
 * @author robh
 */
public class CounterServiceImpl implements CounterService, Serializable {

    private int count = 0;
    
    public int increment() {
        return ++count;
    }
    
    public int decrement() {
        return --count;
    }
}
