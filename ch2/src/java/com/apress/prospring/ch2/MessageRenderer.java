/*
 * Created on Jul 23, 2004
 */
package com.apress.prospring.ch2;

/**
 * @author robh
 */
public interface MessageRenderer {

    public void render();
    
    public void setMessageProvider(MessageProvider provider);
    public MessageProvider getMessageProvider();
}
