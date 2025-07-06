package com.jmc.orm;

import java.sql.Connection;

public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) {
        if (entity == null) {


        }

        return false;
    }

    @Override
    public Iterable<E> find(Class<E> clazz) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> clazz, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> clazz) {
        return null;
    }

    @Override
    public E findFirst(Class<E> clazz, String where) {
        return null;
    }
}
