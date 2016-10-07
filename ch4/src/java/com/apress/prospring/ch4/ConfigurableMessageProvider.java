/*
 * Created on 27-Jul-2004
 */
package com.apress.prospring.ch4;

import com.apress.prospring.ch2.MessageProvider;

/**
 * @author robh
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}