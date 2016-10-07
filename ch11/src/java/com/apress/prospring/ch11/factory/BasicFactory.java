/*
 * Created on Sep 17, 2004
 */
package com.apress.prospring.ch11.factory;

/**
 * @author robh
 */
public class BasicFactory {

    private static final BasicFactory instance;
    
    private OrderService orderService;
    
    static {
        instance = new BasicFactory();
    }
    
    public static BasicFactory getInstance() {
        return instance;
    }
    
    public BasicFactory() {
        this.orderService = new DefaultOrderService();
    }
    
    public OrderService getOrderService() {
        return this.orderService;
    }
}
