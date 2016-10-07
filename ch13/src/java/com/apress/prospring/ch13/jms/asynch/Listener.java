/*
 * Created on 24-Sep-2004
 */
package com.apress.prospring.ch13.jms.asynch;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author robh
 */
public class Listener implements MessageListener {
    public void onMessage(Message msg) {
        System.out.println("Received Message: " + msg);
    }
}