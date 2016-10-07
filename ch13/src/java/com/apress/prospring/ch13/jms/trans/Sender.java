/*
 * Created on 22-Sep-2004
 */
package com.apress.prospring.ch13.jms.trans;

import org.springframework.jms.core.JmsTemplate;

/**
 * @author robh
 */
public class Sender {

    public static final String DESTINATION_NAME = "transDemo";
    
    private JmsTemplate template;
    
    public void setJmsTemplate(JmsTemplate template) {
        this.template = template;
    }
    
    public void sendMessages() {
        for(int x = 0; x < 10; x++) {
            template.convertAndSend(DESTINATION_NAME, "bar");
            
            if(x == 8) {
                throw new RuntimeException("Ha Ha!");
            }
        }
    }
}
