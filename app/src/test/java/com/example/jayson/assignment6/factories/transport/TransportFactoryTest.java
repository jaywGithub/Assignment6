package com.example.jayson.assignment6.factories.transport;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class TransportFactoryTest {
    @Test
    public void testTransport()throws Exception
    {
        String transportMedium = TransportFactory.getTransport("R");

        Assert.assertEquals(transportMedium, "Regular");
    }

    @Test
    public void testUpdate()throws Exception
    {
        String transportMedium = TransportFactory.getTransport("R");

        Assert.assertEquals(transportMedium, "Regular");

        transportMedium = TransportFactory.getTransport("E1");

        Assert.assertEquals(transportMedium, "Express1");
    }
}
