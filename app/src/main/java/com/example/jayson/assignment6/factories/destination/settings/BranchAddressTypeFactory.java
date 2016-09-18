package com.example.jayson.assignment6.factories.destination.settings;

import com.example.jayson.assignment6.domain.destination.settings.BranchAddressType;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class BranchAddressTypeFactory {

    public static BranchAddressType getAddressType(String name)
    {
        BranchAddressType branchAddressType = new BranchAddressType.Builder()
                .name(name)
                .build();

        return branchAddressType;
    }
}
