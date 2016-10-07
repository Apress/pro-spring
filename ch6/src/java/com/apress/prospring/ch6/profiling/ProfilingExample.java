/*
 * Created on Aug 12, 2004
 */
package com.apress.prospring.ch6.profiling;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author robh
 */
public class ProfilingExample {

    public static void main(String[] args) {
        WorkerBean bean = getWorkerBean();
        bean.doSomeWork(10000000);
    }
    
    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();
        
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());
        
        return (WorkerBean)factory.getProxy();
    }
}
