/*
 * Created on 07-Aug-2004
 */
package com.apress.prospring.ch5.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author robh
 */
public class MessageEventListener implements ApplicationListener {

   
    public void onApplicationEvent(ApplicationEvent event) {
       if(event instanceof MessageEvent) {
           MessageEvent msgEvt = (MessageEvent)event;
           System.out.println("Received: " + msgEvt.getMessage());
       }
    }

}
