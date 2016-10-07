/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.jaxrpc;

import java.rmi.RemoteException;

import com.apress.prospring.ch16.remoting.MessageBean;

/**
 * @author robh
 */
public class JaxRpcMessageService implements MessageService {

    public MessageBean getMessage() throws RemoteException {
        MessageBean bean = new MessageBean();
        bean.setMessage("Hello World!");
        bean.setSenderName("Rob Harrop");
        return bean;
    }

}
