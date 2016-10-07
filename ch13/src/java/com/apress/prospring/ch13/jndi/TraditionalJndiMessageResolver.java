/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author robh
 */
public class TraditionalJndiMessageResolver implements MessageResolver {

    private String message;

    public String getMessage() {
        if (message == null) {
            lookupMessage();
        }
        return message;
    }

    private void lookupMessage() {
        try {
            Context ctx = new InitialContext();
            message = (String) ctx.lookup(JndiDemoServlet.JNDI_NAME);
        } catch (NamingException ex) {
            message = ex.getMessage();
        }
    }

}