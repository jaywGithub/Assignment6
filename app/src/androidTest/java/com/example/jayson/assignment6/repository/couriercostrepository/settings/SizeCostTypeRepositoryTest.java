package com.example.jayson.assignment6.repository.couriercostrepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.couriercost.settings.SizeCostType;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.Impl.SizeCostTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class SizeCostTypeRepositoryTest extends AndroidTestCase {

    private static final String TAG = "SIZE COST TYPE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        SizeCostTypeRepository repo = new SizeCostTypeRepositoryImpl(this.getContext());
        // CREATE
        SizeCostType createEntity = new SizeCostType.Builder()
                .size("smallBox")
                .cost(20.0)
                .build();
        SizeCostType insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<SizeCostType> sizeCostTypes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",sizeCostTypes.size()>0);

        //READ ENTITY
        SizeCostType entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        SizeCostType updateEntity = new SizeCostType.Builder()
                .copy(entity)
                .size("mediumBox")
                .build();
        repo.update(updateEntity);
        SizeCostType newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY",30.0,newEntity.getCost());

        // DELETE ENTITY
        repo.delete(updateEntity);
        SizeCostType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
