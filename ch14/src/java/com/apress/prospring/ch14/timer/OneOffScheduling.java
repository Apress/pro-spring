/*
 * Created on Sep 27, 2004
 */
package com.apress.prospring.ch14.timer;

import java.util.Calendar;
import java.util.Timer;

/**
 * @author robh
 */
public class OneOffScheduling {

    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new HelloWorldTask(), 1000);
        
        // use a date instead
        Calendar cal = Calendar.getInstance();
        cal.set(2004, Calendar.NOVEMBER, 31);
        t.schedule(new HelloWorldTask(), cal.getTime());
    }
}
