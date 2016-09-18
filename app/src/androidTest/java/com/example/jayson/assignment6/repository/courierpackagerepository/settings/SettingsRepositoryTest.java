package com.example.jayson.assignment6.repository.courierpackagerepository.settings;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.courierpackage.settings.Settings;
import com.example.jayson.assignment6.repository.courierpackagerepository.settings.Impl.SettingsRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class SettingsRepositoryTest extends AndroidTestCase {

    private static final String TAG = "SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        SettingsRepository repo = new SettingsRepositoryImpl(this.getContext());
        // CREATE
        Settings createEntity = new Settings.Builder()
                .description("clothes")
                .build();
        Settings insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<Settings> settingses = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",settingses.size()>0);

        //READ ENTITY
        Settings entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        Settings updateEntity = new Settings.Builder()
                .copy(entity)
                .description("electronics")
                .build();
        repo.update(updateEntity);
        Settings newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","electronics",newEntity.getDescription());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Settings deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
