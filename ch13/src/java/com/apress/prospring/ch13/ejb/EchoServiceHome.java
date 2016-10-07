/*
 * Created on 20-Sep-2004
 */
package com.apress.prospring.ch13.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * @author robh
 */
public interface EchoServiceHome extends EJBLocalHome {

    public EchoServiceLocal create() throws CreateException;
}
