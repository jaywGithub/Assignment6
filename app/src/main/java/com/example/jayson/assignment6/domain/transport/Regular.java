package com.example.jayson.assignment6.domain.transport;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class Regular extends Transport {

    @Override
    public String handleRequest(String request) {
        if(request.equalsIgnoreCase("R"))
        {
            return "Regular";
        }
        else
        {
            if(transport != null)
            {
                return transport.handleRequest(request);
            }
            return "No Medium";
        }
    }
}
