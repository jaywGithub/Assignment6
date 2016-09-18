package com.example.jayson.assignment6.factories.destination;

import com.example.jayson.assignment6.domain.destination.BranchAddress;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class BranchAddressFactory {

    public static BranchAddress getBranchAddress(String address, String cityName, String areaName)
    {
        return new BranchAddress.Builder()
                .cityName(cityName)
                .areaName(areaName)
                .addressTypeId(address)
                .build();
    }
}
