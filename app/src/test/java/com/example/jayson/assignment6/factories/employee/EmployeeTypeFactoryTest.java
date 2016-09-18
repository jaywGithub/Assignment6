package com.example.jayson.assignment6.factories.employee;

import com.example.jayson.assignment6.domain.employee.settings.Settings;
import com.example.jayson.assignment6.factories.employee.settings.EmployeeTypeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class EmployeeTypeFactoryTest {
    @Test
    public void testCreate() throws Exception
    {
        Settings settings = EmployeeTypeFactory.getEmployeeType("RegularDriver");

        Assert.assertEquals("RegularDriver", settings.getName());
    }

    @Test
    public void testUpdate()throws Exception
    {
        Settings settings = EmployeeTypeFactory.getEmployeeType("RegularDriver");
        Settings newSettings = new Settings
                .Builder()
                .copy(settings)
                .name("Express1Driver")
                .build();

        Assert.assertEquals("Express1Driver", newSettings.getName());
    }
}
