package com.example.jayson.assignment6.factories.customer;

import com.example.jayson.assignment6.domain.customer.Customer;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CustomerFactory {

    public static Customer getCustomer(String name, String surname, String contactNumber)
    {
        return new Customer.Builder()
                .name(name)
                .surname(surname)
                .contactNumber(contactNumber)
                .build();
    }
}
