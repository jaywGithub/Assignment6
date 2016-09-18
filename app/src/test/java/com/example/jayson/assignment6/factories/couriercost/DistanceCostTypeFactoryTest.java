package com.example.jayson.assignment6.factories.couriercost;

import com.example.jayson.assignment6.domain.couriercost.settings.DistanceCostType;
import com.example.jayson.assignment6.factories.couriercost.settings.DistanceCostTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class DistanceCostTypeFactoryTest {
    @Test
    public void testCreate()throws Exception
    {
        DistanceCostType distanceCostType = DistanceCostTypeFactory.getDistanceCostType(150.0, 75.0);

        Assert.assertEquals(75.0, distanceCostType.getCost());
    }

    @Test
    public void testUpdate() throws Exception
    {
        DistanceCostType distanceCostType = DistanceCostTypeFactory.getDistanceCostType(150.0, 75.0);
        DistanceCostType newDistanceCostType = new DistanceCostType
                .Builder()
                .copy(distanceCostType)
                .distance(250.0)
                .build();


        Assert.assertEquals(150.0, newDistanceCostType.getCost());
    }
}
