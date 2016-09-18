package com.example.jayson.assignment6.factories.couriercost;

import com.example.jayson.assignment6.domain.couriercost.settings.SizeCostType;
import com.example.jayson.assignment6.factories.couriercost.settings.SizeCostTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class SizeCostTypeFactoryTest {
    @Test
    public void testCreate()throws Exception
    {
        SizeCostType sizeCostType = SizeCostTypeFactory.getSizeCostType("smallBox", 20.0);

        Assert.assertEquals(20.0, sizeCostType.getCost());
    }

    @Test
    public void testUpdate()throws Exception
    {
        SizeCostType sizeCostType = SizeCostTypeFactory.getSizeCostType("smallBox", 20.0);
        SizeCostType newSizeCostType = new SizeCostType
                .Builder()
                .size("mediumBox")
                .cost(30.0)
                .build();

        Assert.assertEquals(30.0, newSizeCostType.getCost());
    }
}
