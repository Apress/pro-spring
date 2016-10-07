/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.jndi;

import javax.naming.NamingException;

import org.springframework.jndi.JndiTemplate;

/**
 * @author robh
 */
public class JndiTemplateMessageResolver implements MessageResolver {

    private String message;

    public String getMessage() {
        if (message == null) {
            lookupMessage();
        }
        return message;
    }

    private void lookupMessage() {
        JndiTemplate template = new JndiTemplate();

        try {
            message = (String) template.lookup(JndiDemoServlet.JNDI_NAME);
        } catch (NamingException ex) {
            message = ex.getMessage();
        }
    }

}