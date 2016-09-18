package com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.courierpackage.PackageSize;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.Impl.PackageSizeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class PackageSizeRepositoryTest extends AndroidTestCase {

    private static final String TAG = "PACKAGE SIZE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        PackageSizeRepository repo = new PackageSizeRepositoryImpl(this.getContext());
        // CREATE
        PackageSize createEntity = new PackageSize.Builder()
                .smallBox("YES")
                .build();
        PackageSize insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<PackageSize> packageSizes = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",packageSizes.size()>0);

        //READ ENTITY
        PackageSize entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        PackageSize updateEntity = new PackageSize.Builder()
                .copy(entity)
                .smallBox("NO")
                .build();
        repo.update(updateEntity);
        PackageSize newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","NO",newEntity.getSmallBox());

        // DELETE ENTITY
        repo.delete(updateEntity);
        PackageSize deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
