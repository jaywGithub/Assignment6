package com.example.jayson.assignment6.repository.couriercostrepository.couriercost;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.couriercost.TransportCost;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.Impl.TransportCostRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class TransportCostRepositoryTest extends AndroidTestCase {

    private static final String TAG = "TRANSPORT COST TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        TransportCostRepository repo = new TransportCostRepositoryImpl(this.getContext());
        // CREATE
        TransportCost createEntity = new TransportCost.Builder()
                .transportType("Regular")
                .cost(50.0)
                .build();
        TransportCost insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<TransportCost> transportCosts = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",transportCosts.size()>0);

        //READ ENTITY
        TransportCost entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        TransportCost updateEntity = new TransportCost.Builder()
                .copy(entity)
                .transportType("Express2")
                .build();
        repo.update(updateEntity);
        TransportCost newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY",150.0,newEntity.getCost());

        // DELETE ENTITY
        repo.delete(updateEntity);
        TransportCost deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
