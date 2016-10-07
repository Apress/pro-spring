/*
 * Created on Oct 25, 2004
 */
package com.apress.prospring.ch16.remoting.jaxrpc;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;

import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.springframework.remoting.jaxrpc.JaxRpcPortProxyFactoryBean;

import com.apress.prospring.ch16.remoting.MessageBean;

/**
 * @author robh
 */
public class MessageServiceJaxRpcProxyFactoryBean extends
        JaxRpcPortProxyFactoryBean {

    protected void postProcessJaxRpcService(Service service) {
       TypeMappingRegistry tmr = service.getTypeMappingRegistry();
       TypeMapping tm = tmr.createTypeMapping();
       
       QName qname = new QName("http://www.apress.com", "MessageBean");
       
       tm.register(MessageBean.class, qname, 
               new BeanSerializerFactory(MessageBean.class, qname), 
               new BeanDeserializerFactory(MessageBean.class, qname));
       
       tmr.register("http://schemas.xmlsoap.org/soap/encoding/", tm);
    }
}
