/*
 * Created on Jul 28, 2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public class InjectRef {

    private Oracle oracle;
    
    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
        System.out.println(oracle.defineMeaningOfLife());
    }
}
