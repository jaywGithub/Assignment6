package com.example.jayson.assignment6.factories.couriercost;

import com.example.jayson.assignment6.domain.couriercost.DistanceCost;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class DistanceCostFactory {
    public static DistanceCost getDistanceCost(double distance, double cost)
    {
        return new DistanceCost.Builder()
                .distance(distance)
                .cost(cost)
                .build();
    }
}
