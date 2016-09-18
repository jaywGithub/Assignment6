package com.example.jayson.assignment6.domain.courierpackage.settings;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageSizeType implements Serializable {

    private Long id;
    private String name;
    private String state;

    public PackageSizeType(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.state = builder.state;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private String state;

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

        public Builder state(String value)
        {
            this.state = value;
            return this;
        }

        public Builder copy(PackageSizeType packageSizeType)
        {
            this.id = packageSizeType.id;
            this.name = packageSizeType.name;
            this.state = packageSizeType.state;

            return this;
        }

        public PackageSizeType build()
        {
            return new PackageSizeType(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageSizeType aPackageSizeType = (PackageSizeType) o;

        return id != null ? id.equals(aPackageSizeType.id) : aPackageSizeType.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
