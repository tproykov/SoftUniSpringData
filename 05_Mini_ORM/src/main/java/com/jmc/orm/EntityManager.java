package com.jmc.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Optional;

public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) {
    //    getIdField(entity);
    //    getFieldValue();
        if (id == 0) {
            return doInsert(entity);
        }
        return doUpdate(entity);
    }

    private Field getIdField(E entity) {
        Optional<Field> idField = Arrays.stream(entity
                .getClass()
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst();

        if (idField.isEmpty()) {
            throw new RuntimeException("Could not find id field");
        }
        return idField.get();
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
