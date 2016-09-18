package com.example.jayson.assignment6.factories.couriercost;

import com.example.jayson.assignment6.domain.couriercost.settings.TransportCostType;
import com.example.jayson.assignment6.factories.couriercost.settings.TransportCostTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class TransportCostTypeFactoryTest {
    @Test
    public void testCreate()throws Exception
    {
        TransportCostType transportCostType = TransportCostTypeFactory.getTransportType("Regular", 50.0);

        Assert.assertEquals(50.0, transportCostType.getCost());
    }

    @Test
    public void testUpdate()throws Exception
    {
        TransportCostType transportCostType = TransportCostTypeFactory.getTransportType("Regular", 50.0);
        TransportCostType newTransportCostType = new TransportCostType
                .Builder()
                .transportType("Express2")
                .cost(150.0)
                .build();

        Assert.assertEquals(150.0, newTransportCostType.getCost());
    }
}
