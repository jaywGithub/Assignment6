package com.example.jayson.assignment6.factories.couriercost.settings;

import com.example.jayson.assignment6.domain.couriercost.settings.SizeCostType;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class SizeCostTypeFactory {

    public static SizeCostType getSizeCostType(String size, double cost)
    {
        SizeCostType sizeCostType = new SizeCostType.Builder()
                .size(size)
                .cost(cost)
                .build();

        return sizeCostType;
    }
}
