/*
 * Created on 23-Jul-2004
 */
package com.apress.prospring.ch2;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author robh
 */
public class MessageSupportFactory {

    private static MessageSupportFactory instance = null;

    private Properties props = null;

    private MessageRenderer renderer = null;

    private MessageProvider provider = null;

    private MessageSupportFactory() {
        props = new Properties();

        try {
            props.load(new FileInputStream("ch2/src/conf/msf.properties"));

            // get the implementation classes
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }

}