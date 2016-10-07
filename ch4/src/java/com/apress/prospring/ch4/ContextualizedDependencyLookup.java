/*
 * Created on Jul 27, 2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public class ContextualizedDependencyLookup implements ManagedComponent {

    private Dependency dep;

    public void performLookup(Container container) {
        this.dep = (Dependency) container.getDependency("myDependency");
    }

}