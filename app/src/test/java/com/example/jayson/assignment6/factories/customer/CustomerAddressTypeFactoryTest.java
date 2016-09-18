package com.example.jayson.assignment6.factories.customer;

import com.example.jayson.assignment6.domain.customer.settings.CustomerAddressType;
import com.example.jayson.assignment6.factories.customer.settings.CustomerAddressTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CustomerAddressTypeFactoryTest {
    @Test
    public void testCreate() throws Exception
    {
        CustomerAddressType customerAddressType = CustomerAddressTypeFactory.getAddressType("HOME");

        Assert.assertEquals("HOME", customerAddressType.getName());
    }

    @Test
    public void testUpdate()throws Exception
    {
        CustomerAddressType customerAddressType = CustomerAddressTypeFactory.getAddressType("HOME");
        CustomerAddressType newCustomerAddressType = new CustomerAddressType
                .Builder()
                .copy(customerAddressType)
                .name("WORK")
                .build();

        Assert.assertEquals("WORK", newCustomerAddressType.getName());
    }
}
