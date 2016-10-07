/*
 * Created on Aug 12, 2004
 */
package com.apress.prospring.ch6.profiling;

/**
 * @author robh
 */
public class WorkerBean {

    public void doSomeWork(int noOfTimes) {
        for(int x = 0; x < noOfTimes; x++) {
            work();
        }
    }
    
    private void work() {
        System.out.print("");
    }
}
