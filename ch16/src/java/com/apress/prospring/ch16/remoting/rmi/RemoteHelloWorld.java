/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author robh
 */
public interface RemoteHelloWorld extends Remote {

    String getMessage() throws RemoteException;

}
