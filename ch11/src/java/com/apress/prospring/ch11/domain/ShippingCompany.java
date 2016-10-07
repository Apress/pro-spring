/*
 * Created on Sep 15, 2004
 */
package com.apress.prospring.ch11.domain;

/**
 * @author robh
 */
public class ShippingCompany {

    public static final ShippingCompany UPS = new ShippingCompany(1, "UPS");

    public static final ShippingCompany DHL = new ShippingCompany(2, "DHL");

    public static final ShippingCompany FEDEX = new ShippingCompany(3, "FEDEX");

    private final int id;

    private final String name;

    private ShippingCompany(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static ShippingCompany fromInt(int id) {
        if (id == UPS.id) {
            return UPS;
        } else if (id == DHL.id) {
            return DHL;
        } else if (id == FEDEX.id) {
            return FEDEX;
        } else {
            return null;
        }
    }
}