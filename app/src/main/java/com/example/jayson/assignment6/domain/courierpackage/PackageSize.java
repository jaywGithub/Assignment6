package com.example.jayson.assignment6.domain.courierpackage;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageSize implements Serializable {

    private Long id;
    private String smallBox;
    private String mediumBox;
    private String largeBox;
    private String state;

    public PackageSize(){}

    public Long getId()
    {
        return id;
    }

    public String getSmallBox()
    {
        return smallBox;
    }

    public String getMediumBox()
    {
        return mediumBox;
    }

    public String getLargeBox()
    {
        return largeBox;
    }

    public String getState()
    {
        return state;
    }

    public PackageSize(Builder builder)
    {
        this.id = builder.id;
        this.smallBox = builder.smallBox;
        this.mediumBox = builder.mediumBox;
        this.largeBox = builder.largeBox;
        this.state = builder.state;
    }

    public static class Builder
    {
        private Long id;
        private String smallBox;
        private String mediumBox;
        private String largeBox;
        private String state;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder smallBox(String value)
        {
            this.smallBox = value;
            return this;
        }

        public Builder mediumBox(String value)
        {
            this.mediumBox = value;
            return this;
        }

        public Builder largeBox(String value)
        {
            this.largeBox = value;
            return this;
        }

        public Builder state(String value)
        {
            this.state = value;
            return this;
        }

        public Builder copy(PackageSize value)
        {
            this.id = value.id;
            this.smallBox = value.smallBox;
            this.mediumBox = value.mediumBox;
            this.largeBox = value.largeBox;
            this.state = value.state;

            return this;
        }

        public PackageSize build()
        {
            return new PackageSize(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageSize aPackageSize = (PackageSize) o;

        return id != null ? id.equals(aPackageSize.id) : aPackageSize.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
