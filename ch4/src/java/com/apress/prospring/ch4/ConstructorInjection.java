package com.apress.prospring.ch4;
/*
 * Created on Jul 27, 2004
 */

/**
 * @author robh
 */
public class ConstructorInjection {

    private Dependency dep;
    
    public ConstructorInjection(Dependency dep) {
        this.dep = dep;
    }
}
