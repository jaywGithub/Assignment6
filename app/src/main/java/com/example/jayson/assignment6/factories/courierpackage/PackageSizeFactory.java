package com.example.jayson.assignment6.factories.courierpackage;

import com.example.jayson.assignment6.domain.courierpackage.PackageSize;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageSizeFactory {

    public static PackageSize getPackageSize(String smallBox, String mediumBox, String largeBox)
    {
        return new PackageSize.Builder()
                .smallBox(smallBox)
                .mediumBox(mediumBox)
                .largeBox(largeBox)
                .build();
    }
}
