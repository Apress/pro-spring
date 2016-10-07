/*
 * Created on 04-Aug-2004
 */
package com.apress.prospring.ch5.mi;

/**
 * @author robh
 */
public abstract class AbstractLookupDemoBean implements DemoBean {
    
    public abstract MyHelper getMyHelper();
    
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
