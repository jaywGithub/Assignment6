package com.example.jayson.assignment6.domain.destination.settings;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-23.
 */
public class Settings implements Serializable {

    private Long id;
    private String name;

    public Settings(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public static class Builder
    {
        private Long id;
        private String name;

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

        public Builder copy(Settings value)
        {
            this.id = value.id;
            this.name = value.name;

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

        Settings settings = (Settings) o;

        return id != null ? id.equals(settings.id) : settings.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
