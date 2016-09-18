package com.example.jayson.assignment6.repository.couriercostrepository.couriercost;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.couriercost.SizeCost;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.Impl.SizeCostRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class SizeCostRepositoryTest extends AndroidTestCase {

    private static final String TAG = "SIZE COST TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        SizeCostRepository repo = new SizeCostRepositoryImpl(this.getContext());
        // CREATE
        SizeCost createEntity = new SizeCost.Builder()
                .size("smallBox")
                .cost(20.0)
                .build();
        SizeCost insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<SizeCost> sizeCosts = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",sizeCosts.size()>0);

        //READ ENTITY
        SizeCost entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        SizeCost updateEntity = new SizeCost.Builder()
                .copy(entity)
                .size("mediumBox")
                .build();
        repo.update(updateEntity);
        SizeCost newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY",30.0,newEntity.getCost());

        // DELETE ENTITY
        repo.delete(updateEntity);
        SizeCost deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
