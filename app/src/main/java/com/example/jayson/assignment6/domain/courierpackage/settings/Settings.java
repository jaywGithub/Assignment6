package com.example.jayson.assignment6.domain.courierpackage.settings;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-23.
 */
public class Settings implements Serializable {

    private Long id;
    private String description;

    public Settings(Builder builder)
    {
        this.id = builder.id;
        this.description = builder.description;
    }

    public Long getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
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

        public Builder copy(Settings value)
        {
            this.id = value.id;
            this.description = value.description;

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
