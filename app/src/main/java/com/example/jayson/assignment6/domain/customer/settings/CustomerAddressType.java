package com.example.jayson.assignment6.domain.customer.settings;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CustomerAddressType implements Serializable {

    private Long id;
    private String name;
    private String state;

    public CustomerAddressType(Builder builder)
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

        public Builder copy(CustomerAddressType customerAddressType)
        {
            this.id = customerAddressType.id;
            this.name = customerAddressType.name;
            this.state = customerAddressType.state;

            return this;
        }

        public CustomerAddressType build()
        {
            return new CustomerAddressType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddressType customerAddressType = (CustomerAddressType) o;

        return id != null ? id.equals(customerAddressType.id) : customerAddressType.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
