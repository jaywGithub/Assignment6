package com.example.jayson.assignment6.domain.courierpackage;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class Package implements Serializable {

    private Long id;
    private String description;

    private Package(){}

    public Long getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public Package(Builder builder)
    {
        this.id = builder.id;
        this.description = builder.description;
    }

    public static class Builder
    {
        private Long id;
        private String description;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder description(String value)
        {
            this.description = value;
            return this;
        }

        public Builder copy(Package value)
        {
            this.id = value.id;
            this.description = value.description;

            return this;
        }

        public Package build()
        {
            return new Package(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        return id != null ? id.equals(aPackage.id) : aPackage.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
