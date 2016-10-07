/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.ejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import org.springframework.ejb.support.AbstractStatefulSessionBean;

/**
 * @author robh
 */
public class CounterServiceEJB extends AbstractStatefulSessionBean implements
        CounterService {

    private CounterService service;

    public int increment() {
        return service.increment();
    }

    public int decrement() {
        return service.decrement();
    }

    public void ejbCreate() throws CreateException {
        load();
        service = (CounterService) getBeanFactory().getBean("counterService");
    }

    public void ejbActivate() throws EJBException, RemoteException {
        load();
        service = (CounterService) getBeanFactory().getBean("counterService");
    }

    public void ejbPassivate() throws EJBException, RemoteException {
        unload();
    }

    private void load() {
        loadBeanFactory();
    }

    private void unload() {
        unloadBeanFactory();
        setBeanFactoryLocator(null);
    }

}