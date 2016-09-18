package com.example.jayson.assignment6.domain.couriercost;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-22.
 */
public class TransportCost implements Serializable {

    private Long id;
    private String transportType;
    private double cost;
    private String state;

    public TransportCost(){}

    public Long getId()
    {
        return id;
    }

    public String getTransportType()
    {
        return transportType;
    }

    public double getCost()
    {
        if(transportType.equalsIgnoreCase("Regular"))
        {
            cost = 50.0;
        }

        else if(transportType.equalsIgnoreCase("Express1"))
        {
            cost = 100.0;
        }

        else if(transportType.equalsIgnoreCase("Express2"))
        {
            cost = 150.0;
        }

        return cost;
    }

    public String getState()
    {
        return state;
    }

    public TransportCost(Builder builder)
    {
        this.id = builder.id;
        this.transportType = builder.transportType;
        this.cost = builder.cost;
        this.state = builder.state;
    }

    public static class Builder
    {
        private Long id;
        private String transportType;
        private double cost;
        private String state;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder transportType(String value)
        {
            this.transportType = value;
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

        public Builder copy(TransportCost value)
        {
            this.id = value.id;
            this.transportType = value.transportType;
            this.cost = value.cost;
            this.state = value.state;

            return this;
        }

        public TransportCost build()
        {
            return new TransportCost(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportCost transportCost = (TransportCost) o;

        return id != null ? id.equals(transportCost.id) : transportCost.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
