package com.example.jayson.assignment6.repository.destinationrepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.destination.settings.BranchAddressType;
import com.example.jayson.assignment6.repository.destinationrepository.settings.Impl.BranchAddressTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class BranchAddressTypeTest extends AndroidTestCase {

    private static final String TAG = "BRANCH ADDRESS TYPE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        BranchAddressTypeRepository repo = new BranchAddressTypeRepositoryImpl(this.getContext());
        // CREATE
        BranchAddressType createEntity = new BranchAddressType.Builder()
                .name("Cape Town")
                .build();
        BranchAddressType insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<BranchAddressType> branchAddressTypes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",branchAddressTypes.size()>0);

        //READ ENTITY
        BranchAddressType entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        BranchAddressType updateEntity = new BranchAddressType.Builder()
                .copy(entity)
                .name("Bloemfontein")
                .build();
        repo.update(updateEntity);
        BranchAddressType newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Bloemfontein",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        BranchAddressType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
