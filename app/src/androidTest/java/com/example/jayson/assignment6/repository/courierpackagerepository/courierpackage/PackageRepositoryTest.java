package com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.courierpackage.Package;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.Impl.PackageRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class PackageRepositoryTest extends AndroidTestCase {

    private static final String TAG = "PACKAGE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        PackageRepository repo = new PackageRepositoryImpl(this.getContext());
        // CREATE
        Package createEntity = new Package.Builder()
                .description("clothes")
                .build();
        Package insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<Package> packages = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",packages.size()>0);

        //READ ENTITY
        Package entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        Package updateEntity = new Package.Builder()
                .copy(entity)
                .description("electronics")
                .build();
        repo.update(updateEntity);
        Package newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","electronics",newEntity.getDescription());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Package deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
