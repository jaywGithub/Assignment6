package com.example.jayson.assignment6.domain.transport;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class Express1 extends Transport {

    @Override
    public String handleRequest(String request) {
        if(request.equalsIgnoreCase("E1"))
        {
            return "Express1";
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
