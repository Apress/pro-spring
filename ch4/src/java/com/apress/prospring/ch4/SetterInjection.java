package com.apress.prospring.ch4;
/*
 * Created on Jul 27, 2004
 */

/**
 * @author robh
 */
public class SetterInjection {

    private Dependency dep;
    
    public void setMyDependency(Dependency dep) {
        this.dep = dep;
    }
}
