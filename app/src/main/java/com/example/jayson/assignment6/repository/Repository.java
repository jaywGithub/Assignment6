package com.example.jayson.assignment6.repository;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-22.
 */
    public interface Repository<E, ID> {

        E findById(ID id);

        E save(E entity);

        E update(E entity);

        E delete(E entity);

        Set<E> findAll();

        int deleteAll();
}
