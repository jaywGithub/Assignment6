package com.example.jayson.assignment6.factories.destination;

import com.example.jayson.assignment6.domain.destination.Branch;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class BranchFactory {

    public static Branch getBranch(String name)
    {
        return new Branch.Builder()
                .name(name)
                .build();
    }
}
