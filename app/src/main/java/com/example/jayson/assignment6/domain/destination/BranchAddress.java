package com.example.jayson.assignment6.domain.destination;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class BranchAddress implements Serializable {

    private Long id;
    private String cityName;
    private String areaName;
    private String areaCode;
    private String addressTypeId;
    private String state;

    public BranchAddress(){}

    public Long getId()
    {
        return id;
    }

    public String getCityName()
    {
        return cityName;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public String getAddressTypeId()
    {
        return addressTypeId;
    }

    public String getState()
    {
        return state;
    }

    public BranchAddress(Builder builder)
    {
        this.id = builder.id;
        this.cityName = builder.cityName;
        this.areaName = builder.areaName;
        this.areaCode = builder.areaCode;
        this.addressTypeId = builder.addressTypeId;
        this.state = builder.state;
    }

    public static class Builder {
        private Long id;
        private String cityName;
        private String areaName;
        private String areaCode;
        private String addressTypeId;
        private String state;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder cityName(String value) {
            this.cityName = value;
            return this;
        }

        public Builder areaName(String value) {
            this.areaName = value;
            return this;
        }

        public Builder areaCode(String value) {
            this.areaCode = value;
            return this;
        }

        public Builder addressTypeId(String value) {
            this.addressTypeId = value;
            return this;
        }

        public Builder state(String value) {
            this.state = value;
            return this;
        }

        public Builder copy(BranchAddress value) {
            this.id = value.id;
            this.cityName = value.cityName;
            this.areaName = value.areaName;
            this.areaCode = value.areaCode;
            this.addressTypeId = value.addressTypeId;
            this.state = value.state;

            return this;
        }

        public BranchAddress build()
        {
            return new BranchAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchAddress branchAddress = (BranchAddress) o;

        return id != null ? id.equals(branchAddress.id) : branchAddress.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
