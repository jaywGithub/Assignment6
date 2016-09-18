package com.example.jayson.assignment6.factories.courierpackage;

import com.example.jayson.assignment6.domain.courierpackage.settings.PackageSizeType;
import com.example.jayson.assignment6.factories.courierpackage.settings.PackageSizeTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageSizeTypeFactoryTest {
    @Test
    public void testCreate()throws Exception
    {
        PackageSizeType packageSizeType = PackageSizeTypeFactory.getPackageSizeType("smallBox");

        Assert.assertEquals("smallBox", packageSizeType.getName());
    }

    @Test
    public void testUpdate() throws Exception
    {
        PackageSizeType packageSizeType = PackageSizeTypeFactory.getPackageSizeType("smallBox");
        PackageSizeType newPackageSizeType = new PackageSizeType
                .Builder()
                .copy(packageSizeType )
                .name("mediumBox")
                .build();

        Assert.assertEquals("mediumBox", newPackageSizeType.getName());
    }
}
