package com.example.jayson.assignment6.repository.customerrepository.customer;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.customer.Customer;
import com.example.jayson.assignment6.repository.customerrepository.customer.Impl.CustomerRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class CustomerRepositoryTest extends AndroidTestCase {

    private static final String TAG = "CUSTOMER TEST";
    private Long id;


    public void testCreateReadUpdateDelete()throws Exception
    {
        CustomerRepository repo = new CustomerRepositoryImpl(this.getContext());
        // CREATE
        Customer createEntity = new Customer.Builder()
                .name("Jayson")
                .surname("Peters")
                .contactNumber("021 123 4567")
                .build();
        Customer insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<Customer> customers = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",customers.size()>0);

        //READ ENTITY
        Customer entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        Customer updateEntity = new Customer.Builder()
                .copy(entity)
                .name("Warren")
                .build();
        repo.update(updateEntity);
        Customer newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Warren",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Customer deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
