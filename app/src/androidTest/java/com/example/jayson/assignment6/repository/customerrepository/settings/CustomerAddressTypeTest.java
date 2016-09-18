package com.example.jayson.assignment6.repository.customerrepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.customer.settings.CustomerAddressType;
import com.example.jayson.assignment6.repository.customerrepository.settings.Impl.CustomerAddressTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class CustomerAddressTypeTest extends AndroidTestCase {

    private static final String TAG = "CUSTOMER ADDRESS TYPE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        CustomerAddressTypeRepository repo = new CustomerAddressTypeRepositoryImpl(this.getContext());
        // CREATE
        CustomerAddressType createEntity = new CustomerAddressType.Builder()
                .name("Cape Town")
                .build();
        CustomerAddressType insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<CustomerAddressType> customerAddressTypes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",customerAddressTypes.size()>0);

        //READ ENTITY
        CustomerAddressType entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        CustomerAddressType updateEntity = new CustomerAddressType.Builder()
                .copy(entity)
                .name("Bloemfontein")
                .build();
        repo.update(updateEntity);
        CustomerAddressType newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Bloemfontein",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        CustomerAddressType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
