package com.example.jayson.assignment6.factories.customer;

import com.example.jayson.assignment6.domain.customer.CustomerAddress;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CustomerAddressFactory {

    public static CustomerAddress getCustomerAddress(String address, String cityName, String areaName)
    {
        return new CustomerAddress.Builder()
                .cityName(cityName)
                .areaName(areaName)
                .addressTypeId(address)
                .build();
    }
}
