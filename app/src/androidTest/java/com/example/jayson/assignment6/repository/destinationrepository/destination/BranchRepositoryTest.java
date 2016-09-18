package com.example.jayson.assignment6.repository.destinationrepository.destination;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.destination.Branch;
import com.example.jayson.assignment6.repository.destinationrepository.destination.Impl.BranchRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class BranchRepositoryTest extends AndroidTestCase {

    private static final String TAG = "BRANCH TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        BranchRepository repo = new BranchRepositoryImpl(this.getContext());
        // CREATE
        Branch createEntity = new Branch.Builder()
                .name("Durban")
                .build();
        Branch insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<Branch> branches = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",branches.size()>0);

        //READ ENTITY
        Branch entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        Branch updateEntity = new Branch.Builder()
                .copy(entity)
                .name("Port-Elizabeth")
                .build();
        repo.update(updateEntity);
        Branch newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Port-Elizabeth",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Branch deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
