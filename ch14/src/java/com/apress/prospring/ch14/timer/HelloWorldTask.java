/*
 * Created on Sep 27, 2004
 */
package com.apress.prospring.ch14.timer;

import java.util.TimerTask;

/**
 * @author robh
 */
public class HelloWorldTask extends TimerTask {

    public void run() {
        System.out.println("Hello World!");        
    }
}