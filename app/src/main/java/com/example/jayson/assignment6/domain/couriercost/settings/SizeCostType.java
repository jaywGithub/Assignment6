package com.example.jayson.assignment6.domain.couriercost.settings;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class SizeCostType implements Serializable {

    private Long id;
    private String size;
    private double cost;
    private String state;

    public SizeCostType(Builder builder)
    {
        this.id = builder.id;
        this.size = builder.size;
        this.cost = builder.cost;
        this.state = builder.state;
    }

    public Long getId()
    {
        return id;
    }

    public String getSize()
    {
        return size;
    }

    public double getCost()
    {
        if(size.equalsIgnoreCase("smallBox"))
        {
            cost = 20.0;
        }

        else if(size.equalsIgnoreCase("mediumBox"))
        {
            cost = 30.0;
        }

        else if(size.equalsIgnoreCase("largeBox"))
        {
            cost = 50.0;
        }

        return cost;
    }

    public String getState()
    {
        return state;
    }

    public static class Builder
    {
        private Long id;
        private String size;
        private double cost;
        private String state;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder size(String value)
        {
            this.size = value;
            return this;
        }

        public Builder cost(double value)
        {
            this.cost = value;
            return this;
        }

        public Builder state(String value)
        {
            this.state = value;
            return this;
        }

        public Builder copy(SizeCostType value)
        {
            this.id = value.id;
            this.size = value.size;
            this.cost = value.cost;
            this.state = value.state;

            return this;
        }

        public SizeCostType build()
        {
            return new SizeCostType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SizeCostType sizeCostType = (SizeCostType) o;

        return id != null ? id.equals(sizeCostType.id) : sizeCostType.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
