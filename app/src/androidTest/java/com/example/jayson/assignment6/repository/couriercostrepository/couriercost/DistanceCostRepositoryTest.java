package com.example.jayson.assignment6.repository.couriercostrepository.couriercost;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.couriercost.DistanceCost;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.Impl.DistanceCostRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class DistanceCostRepositoryTest extends AndroidTestCase {

    private static final String TAG = "DISTANCE COST TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        DistanceCostRepository repo = new DistanceCostRepositoryImpl(this.getContext());
        // CREATE
        DistanceCost createEntity = new DistanceCost.Builder()
                .distance(250.0)
                .cost(150.0)
                .build();
        DistanceCost insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<DistanceCost> distanceCostss = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",distanceCostss.size()>0);

        //READ ENTITY
        DistanceCost entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        DistanceCost updateEntity = new DistanceCost.Builder()
                .copy(entity)
                .distance(1000.0)
                .build();
        repo.update(updateEntity);
        DistanceCost newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY",400.0,newEntity.getCost());

        // DELETE ENTITY
        repo.delete(updateEntity);
        DistanceCost deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
