/*
 * Created on Sep 17, 2004
 */
package com.apress.prospring.ch11.factory;

/**
 * @author robh
 */
public class MultiFactory {

    private static final BasicFactory instance;
    
    private OrderService orderService;
    private OrderService superOrderService;
    
    static {
        instance = new BasicFactory();
    }
    
    public static BasicFactory getInstance() {
        return instance;
    }
    
    public MultiFactory() {
        this.orderService = new DefaultOrderService();
        this.superOrderService = new SuperOrderService();
    }
    
    public OrderService getOrderService() {
        return this.orderService;
    }
    
    public OrderService getSuperOrderService() {
        return this.superOrderService;
    }
}
