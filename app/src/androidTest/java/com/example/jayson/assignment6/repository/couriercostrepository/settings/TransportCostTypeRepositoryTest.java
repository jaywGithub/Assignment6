package com.example.jayson.assignment6.repository.couriercostrepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.couriercost.settings.TransportCostType;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.Impl.TransportCostTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class TransportCostTypeRepositoryTest extends AndroidTestCase {

    private static final String TAG = "TRANSPORT COST TYPE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        TransportCostTypeRepository repo = new TransportCostTypeRepositoryImpl(this.getContext());
        // CREATE
        TransportCostType createEntity = new TransportCostType.Builder()
                .transportType("Regular")
                .cost(50.0)
                .build();
        TransportCostType insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<TransportCostType> transportCostTypes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",transportCostTypes.size()>0);

        //READ ENTITY
        TransportCostType entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        TransportCostType updateEntity = new TransportCostType.Builder()
                .copy(entity)
                .transportType("Express2")
                .build();
        repo.update(updateEntity);
        TransportCostType newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY",150.0,newEntity.getCost());

        // DELETE ENTITY
        repo.delete(updateEntity);
        TransportCostType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
