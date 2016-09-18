package com.example.jayson.assignment6.repository.customerrepository.customer;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.customer.CustomerAddress;
import com.example.jayson.assignment6.repository.customerrepository.customer.Impl.CustomerAddressRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class CustomerAddressRepositoryTest extends AndroidTestCase {

    private static final String TAG = "CUSTOMER ADDRESS TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        CustomerAddressRepository repo = new CustomerAddressRepositoryImpl(this.getContext());
        // CREATE
        CustomerAddress createEntity = new CustomerAddress.Builder()
                .cityName("Cape Town")
                .areaName("District Six")
                .areaCode("8000")
                .build();
        CustomerAddress insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<CustomerAddress> customerAddresses = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",customerAddresses.size()>0);

        //READ ENTITY
        CustomerAddress entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        CustomerAddress updateEntity = new CustomerAddress.Builder()
                .copy(entity)
                .areaName("Observatory")
                .build();
        repo.update(updateEntity);
        CustomerAddress newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Observatory",newEntity.getAreaName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        CustomerAddress deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
