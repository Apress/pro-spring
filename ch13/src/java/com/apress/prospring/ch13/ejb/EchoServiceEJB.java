/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.ejb;

import javax.ejb.CreateException;

import org.springframework.ejb.support.AbstractStatelessSessionBean;

/**
 * @author robh
 */
public class EchoServiceEJB extends AbstractStatelessSessionBean implements
        EchoService {

    private static final String BEAN_NAME = "echoService";

    private EchoService service;

    public String echo(String message) {
        return service.echo(message);
    }

    protected void onEjbCreate() throws CreateException {
        service = (EchoService) getBeanFactory().getBean(BEAN_NAME);
    }
}