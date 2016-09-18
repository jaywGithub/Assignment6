package com.example.jayson.assignment6.domain.employee;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class Employee implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String license;

    private Employee(){}

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getLicense()
    {
        return license;
    }

    public Employee(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.license = builder.license;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private String surname;
        private String license;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder license(String value)
        {
            this.license = value;
            return this;
        }

        public Builder copy(Employee value)
        {
            this.id = value.id;
            this.name = value.name;
            this.surname = value.surname;
            this.license = value.license;

            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id != null ? id.equals(employee.id) : employee.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
