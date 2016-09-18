package com.example.jayson.assignment6.factories.destination;

import com.example.jayson.assignment6.domain.destination.settings.BranchAddressType;
import com.example.jayson.assignment6.factories.destination.settings.BranchAddressTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class BranchAddressTypeFactoryTest {
    @Test
    public void testCreate() throws Exception
    {
        BranchAddressType branchAddressType = BranchAddressTypeFactory.getAddressType("BRANCH4");

        Assert.assertEquals("BRANCH4", branchAddressType.getName());
    }

    @Test
    public void testUpdate() throws Exception
    {
        BranchAddressType branchAddressType = BranchAddressTypeFactory.getAddressType("BRANCH4");
        BranchAddressType newBranchAddressType = new BranchAddressType
                .Builder()
                .copy(branchAddressType)
                .name("BRANCH7")
                .build();

        Assert.assertEquals("BRANCH7", newBranchAddressType.getName());
    }
}
