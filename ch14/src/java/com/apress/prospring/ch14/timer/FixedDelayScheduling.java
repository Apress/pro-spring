/*
 * Created on Sep 27, 2004
 */
package com.apress.prospring.ch14.timer;

import java.util.Timer;

/**
 * @author robh
 */
public class FixedDelayScheduling {

    public static void main(String[] args) throws Exception{
        Timer t = new Timer();
        t.schedule(new HelloWorldTask(), 1000, 3000);
    }
}
