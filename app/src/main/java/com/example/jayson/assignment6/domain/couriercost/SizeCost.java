package com.example.jayson.assignment6.domain.couriercost;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class SizeCost implements Serializable {

    private Long id;
    private String size;
    private double cost;
    private String state;

    public SizeCost(){}

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

    public SizeCost(Builder builder)
    {
        this.id = builder.id;
        this.size = builder.size;
        this.cost = builder.cost;
        this.state = builder.state;
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

        public Builder copy(SizeCost value)
        {
            this.id = value.id;
            this.size = value.size;
            this.cost = value.cost;
            this.state = value.state;

            return this;
        }

        public SizeCost build()
        {
            return new SizeCost(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SizeCost sizeCost = (SizeCost) o;

        return id != null ? id.equals(sizeCost.id) : sizeCost.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
