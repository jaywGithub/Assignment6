package com.example.jayson.assignment6.repository.courierpackagerepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.courierpackage.settings.PackageSizeType;
import com.example.jayson.assignment6.repository.courierpackagerepository.settings.Impl.PackageSizeTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class PackageSizeTypeRepositoryTest extends AndroidTestCase {

    private static final String TAG = "PACKAGE SIZE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        PackageSizeTypeRespository repo = new PackageSizeTypeRepositoryImpl(this.getContext());
        // CREATE
        PackageSizeType createEntity = new PackageSizeType.Builder()
                .name("smallBox")
                .build();
        PackageSizeType insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<PackageSizeType> packageSizeTypes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",packageSizeTypes.size()>0);

        //READ ENTITY
        PackageSizeType entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        PackageSizeType updateEntity = new PackageSizeType.Builder()
                .copy(entity)
                .name("mediumBox")
                .build();
        repo.update(updateEntity);
        PackageSizeType newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","mediumBox",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        PackageSizeType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
