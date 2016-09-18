package com.example.jayson.assignment6.factories.couriercost;

import com.example.jayson.assignment6.domain.couriercost.SizeCost;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class SizeCostFactory {

    public static SizeCost getSizeCost(String size, double cost)
    {
        return new SizeCost.Builder()
                .size(size)
                .cost(cost)
                .build();
    }
}
