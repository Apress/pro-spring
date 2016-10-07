/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.jndi;

import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.jndi.JndiCallback;
import org.springframework.jndi.JndiTemplate;

/**
 * @author robh
 */
public class BulkLookupBean {

    private static final String MESSAGE1 = "java:/comp/env/message1";

    private static final String MESSAGE2 = "java:/comp/env/message2";

    private static final String MESSAGE3 = "java:/comp/env/message3";

    private static final String MESSAGE4 = "java:/comp/env/message4";

    public void doLookup() {
        String[] names = new String[] { MESSAGE1, MESSAGE2, MESSAGE3, MESSAGE4 };
        
        JndiTemplate template = new JndiTemplate();

        try {
            String[] messages = (String[]) template
                    .execute(new BulkLookupCallback(names));
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    private class BulkLookupCallback implements JndiCallback {

        private String[] names;

        public BulkLookupCallback(String[] names) {
            this.names = names;
        }

        public Object doInContext(Context ctx) throws NamingException {
            String[] messages = new String[names.length];

            for (int x = 0; x < names.length; x++) {
                messages[x] = (String) ctx.lookup(names[x]);
            }

            return messages;
        }

    }
}