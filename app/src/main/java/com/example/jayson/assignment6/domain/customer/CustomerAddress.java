package com.example.jayson.assignment6.domain.customer;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CustomerAddress implements Serializable {

    private Long id;
    private String cityName;
    private String areaName;
    private String areaCode;
    private String addressTypeId;
    private String state;

    public CustomerAddress(){}

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

    public CustomerAddress(Builder builder)
    {
        this.id = builder.id;
        this.cityName = builder.cityName;
        this.areaName = builder.areaName;
        this.areaCode = builder.areaCode;
        this.addressTypeId = builder.addressTypeId;
        this.state = builder.state;
    }

    public static class Builder
    {
        private Long id;
        private String cityName;
        private String areaName;
        private String areaCode;
        private String addressTypeId;
        private String state;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder cityName(String value)
        {
            this.cityName = value;
            return this;
        }

        public Builder areaName(String value)
        {
            this.areaName = value;
            return this;
        }

        public Builder areaCode(String value)
        {
            this.areaCode = value;
            return this;
        }

        public Builder addressTypeId(String value)
        {
            this.addressTypeId = value;
            return this;
        }

        public Builder state(String value)
        {
            this.state = value;
            return this;
        }

        public Builder copy(CustomerAddress value)
        {
            this.id = value.id;
            this.cityName = value.cityName;
            this.areaName = value.areaName;
            this.areaCode = value.areaCode;
            this.addressTypeId = value.addressTypeId;
            this.state = value.state;

            return this;
        }

        public CustomerAddress build()
        {
            return new CustomerAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress customerAddress = (CustomerAddress) o;

        return id != null ? id.equals(customerAddress.id) : customerAddress.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
