/*
 * Created on 07-Aug-2004
 */
package com.apress.prospring.ch5.event;

import org.springframework.context.ApplicationEvent;


public class MessageEvent extends ApplicationEvent {

    private String msg;
    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
    
    public String getMessage() {
        return msg;
    }
    
}