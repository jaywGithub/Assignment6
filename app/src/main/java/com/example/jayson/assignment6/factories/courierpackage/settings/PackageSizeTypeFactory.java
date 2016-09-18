package com.example.jayson.assignment6.factories.courierpackage.settings;

import com.example.jayson.assignment6.domain.courierpackage.settings.PackageSizeType;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageSizeTypeFactory {
    public static PackageSizeType getPackageSizeType(String name)
    {
        PackageSizeType packageSizeType = new PackageSizeType.Builder()
                .name(name)
                .build();

        return packageSizeType;
    }
}
