package com.example.jayson.assignment6.factories.employee.settings;

import com.example.jayson.assignment6.domain.employee.settings.Settings;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class EmployeeTypeFactory {

    public static Settings getEmployeeType(String name)
    {
        Settings settings = new Settings.Builder()
                .name(name)
                .build();

        return settings;
    }
}
