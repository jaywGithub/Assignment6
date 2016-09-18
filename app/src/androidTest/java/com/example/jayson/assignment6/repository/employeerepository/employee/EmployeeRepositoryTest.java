package com.example.jayson.assignment6.repository.employeerepository.employee;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.employee.Employee;
import com.example.jayson.assignment6.repository.employeerepository.employee.Impl.EmployeeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class EmployeeRepositoryTest extends AndroidTestCase {

    private static final String TAG = "EMPLOYEE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        EmployeeRepository repo = new EmployeeRepositoryImpl(this.getContext());
        // CREATE
        Employee createEntity = new Employee.Builder()
                .name("Jayson")
                .surname("Peters")
                .license("Regular")
                .build();
        Employee insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<Employee> employees = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL",employees.size()>0);

        //READ ENTITY
        Employee entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        Employee updateEntity = new Employee.Builder()
                .copy(entity)
                .name("Warren")
                .build();
        repo.update(updateEntity);
        Employee newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","Warren",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Employee deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
