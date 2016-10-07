/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.timer.bday;

import java.util.TimerTask;

/**
 * @author robh
 */
public class BirthdayReminder extends TimerTask {

    private String who;

    public void setWho(String who) {
        this.who = who;
    }

    public void run() {
        System.out.println("Don't forget it is " + who
                + "'s birthday is 7 days");
    }

}