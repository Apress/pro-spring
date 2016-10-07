/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.jaxrpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.apress.prospring.ch16.remoting.MessageBean;

/**
 * @author robh
 */
public interface MessageService extends Remote {

    MessageBean getMessage() throws RemoteException;
}
