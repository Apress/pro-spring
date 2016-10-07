/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.rmi;

import java.rmi.RemoteException;

/**
 * @author robh
 */
public class SimpleRemoteHelloWorld implements RemoteHelloWorld {

    public String getMessage() throws RemoteException {
        return "Hello World";
    }

}