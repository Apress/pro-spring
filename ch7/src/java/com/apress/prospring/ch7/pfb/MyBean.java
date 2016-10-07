/*
 * Created on Sep 8, 2004
 */
package com.apress.prospring.ch7.pfb;

/**
 * @author robh
 */
public class MyBean {

    private MyDependency dep;
    
    public void execute() {
        dep.foo();
        dep.bar();
    }
    
    public void setDep(MyDependency dep) {
        this.dep = dep;
    }
}
