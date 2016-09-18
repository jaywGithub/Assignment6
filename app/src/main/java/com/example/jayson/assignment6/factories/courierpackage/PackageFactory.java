package com.example.jayson.assignment6.factories.courierpackage;

import com.example.jayson.assignment6.domain.courierpackage.Package;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageFactory {

    public static Package getPackage(String description)
    {
        return new Package.Builder()
                .description(description)
                .build();
    }
}
