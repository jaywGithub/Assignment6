package com.example.jayson.assignment6.factories.customer.settings;

import com.example.jayson.assignment6.domain.customer.settings.CustomerAddressType;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CustomerAddressTypeFactory {

    public static CustomerAddressType getAddressType(String name)
    {
        CustomerAddressType customerAddressType = new CustomerAddressType.Builder()
                .name(name)
                .build();

        return customerAddressType;
    }
}
