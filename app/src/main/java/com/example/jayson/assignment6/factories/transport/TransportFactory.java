package com.example.jayson.assignment6.factories.transport;

import com.example.jayson.assignment6.domain.transport.Express1;
import com.example.jayson.assignment6.domain.transport.Express2;
import com.example.jayson.assignment6.domain.transport.Regular;
import com.example.jayson.assignment6.domain.transport.Transport;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class TransportFactory {

    public static String getTransport(String medium)
    {
        Transport chain = setUpChain();
        return chain.handleRequest(medium);
    }

    public static Regular setUpChain()
    {
        Regular regular = new Regular();
        Express1 express1 = new Express1();
        Express2 express2 = new Express2();

        regular.setNextMedium(express1);
        express1.setNextMedium(express2);

        return regular;
    }
}
