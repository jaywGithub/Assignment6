package com.example.jayson.assignment6.repository.couriercostrepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.couriercost.settings.DistanceCostType;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.Impl.DistanceCostTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class DistanceCostTypeRepositoryTest extends AndroidTestCase {

    private static final String TAG = "DISTANCE COST TYPE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        DistanceCostTypeRepository repo = new DistanceCostTypeRepositoryImpl(this.getContext());
        // CREATE
        DistanceCostType createEntity = new DistanceCostType.Builder()
                .distance(250.0)
                .cost(150.0)
                .build();
        DistanceCostType insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<DistanceCostType> distanceCostTypes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",distanceCostTypes.size()>0);

        //READ ENTITY
        DistanceCostType entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        DistanceCostType updateEntity = new DistanceCostType.Builder()
                .copy(entity)
                .distance(1000.0)
                .build();
        repo.update(updateEntity);
        DistanceCostType newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY",400.0,newEntity.getCost());

        // DELETE ENTITY
        repo.delete(updateEntity);
        DistanceCostType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
