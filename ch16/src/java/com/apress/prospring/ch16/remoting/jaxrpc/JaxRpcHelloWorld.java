/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.jaxrpc;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

import com.apress.prospring.ch16.remoting.HelloWorld;
import com.apress.prospring.ch16.remoting.rmi.RemoteHelloWorld;

/**
 * @author robh
 */
public class JaxRpcHelloWorld extends ServletEndpointSupport implements
        RemoteHelloWorld {

    private HelloWorld helloWorld;

    protected void onInit() throws ServiceException {
        helloWorld = (HelloWorld) getApplicationContext().getBean(
                "helloWorldService");
    }

    public String getMessage() throws RemoteException {
        return helloWorld.getMessage();
    }

}