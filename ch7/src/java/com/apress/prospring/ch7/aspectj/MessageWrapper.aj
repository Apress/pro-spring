/*
 * Created on Sep 9, 2004
 */
package com.apress.prospring.ch7.aspectj;


/**
 * *
 * 
 * @author robh
 */
public aspect MessageWrapper {

    private String prefix;
    private String suffix;
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }   
    
    pointcut doWriting() : 
        execution(* 
           com.apress.prospring.ch7.aspectj.MessageWriter.writeMessage());
    
    before() : doWriting() {
        System.out.println(prefix);
    }
    
    after() : doWriting() {
        System.out.println(suffix);
    }
}
