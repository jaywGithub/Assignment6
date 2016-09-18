package com.example.jayson.assignment6.domain.transport;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class Express2 extends Transport {

    @Override
    public String handleRequest(String request) {
        if(request.equalsIgnoreCase("E2"))
        {
            return "Express2";
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
