package com.example.jayson.assignment6.domain.transport;

/**
 * Created by JAYSON on 2016-04-17.
 */
public abstract class Transport {

    Transport transport;

    public void setNextMedium(Transport transport)
    {
        this.transport = transport;
    }

    public abstract String handleRequest(String request);
}
