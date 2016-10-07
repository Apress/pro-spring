/*
 * Created on 04-Aug-2004
 */
package com.apress.prospring.ch5.mi;

/**
 * @author robh
 */
public class StandardLookupDemoBean implements DemoBean {

    private MyHelper helper;
    
    public void setMyHelper(MyHelper helper) {
        this.helper = helper;
    }
    
    public MyHelper getMyHelper() {
        return this.helper;
    }
    
    public void someOperation() {
        helper.doSomethingHelpful();
    }
}
