package com.example.jayson.assignment6.repository.destinationrepository.destination;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.destination.BranchAddress;
import com.example.jayson.assignment6.repository.destinationrepository.destination.Impl.BranchAddressRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class BranchAddressRepositoryTest extends AndroidTestCase {

    private static final String TAG = "BRANCH ADDRESS TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        BranchAddressRepository repo = new BranchAddressRepositoryImpl(this.getContext());
        // CREATE
        BranchAddress createEntity = new BranchAddress.Builder()
                .cityName("Cape Town")
                .areaName("District Six")
                .areaCode("8000")
                .build();
        BranchAddress insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<BranchAddress> branchAddresses = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",branchAddresses.size()>0);

        //READ ENTITY
        BranchAddress entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        BranchAddress updateEntity = new BranchAddress.Builder()
                .copy(entity)
                .cityName("Bloemfontein")
                .build();
        repo.update(updateEntity);
        BranchAddress newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Bloemfontein",newEntity.getCityName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        BranchAddress deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
