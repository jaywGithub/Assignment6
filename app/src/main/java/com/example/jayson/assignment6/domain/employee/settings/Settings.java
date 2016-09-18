package com.example.jayson.assignment6.domain.employee.settings;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class Settings implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String license;

    public Settings(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.license = builder.license;
    }

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

        public Builder copy(Settings settings)
        {
            this.id = settings.id;
            this.name = settings.name;
            this.surname = settings.surname;
            this.license = settings.license;

            return this;
        }

        public Settings build()
        {
            return new Settings(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Settings customerAddressType = (Settings) o;

        return id != null ? id.equals(customerAddressType.id) : customerAddressType.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
