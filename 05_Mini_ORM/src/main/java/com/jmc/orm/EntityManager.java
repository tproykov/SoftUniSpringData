package com.jmc.orm;

import com.jmc.orm.annotations.Entity;
import com.jmc.orm.annotations.Id;
import com.jmc.orm.exceptions.ORMException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        // TODO: Check if this is an @Entity class
        Field idField = getIdField(entity);
        int id = getIdFieldValue(entity, idField);

        if (id == 0) {
            return doInsert(entity);
        }
        return false;
        // return doUpdate(entity);
    }

    private boolean doInsert(E entity) throws ORMException, SQLException {
        String insertTemplate = "INSERT INTO %s (%s) VALUES (%s)";
        String tableName = getTableName(entity);
        String columnName = entity.getClass().getSimpleName();
        String values = String.format(insertTemplate, tableName, columnName);

        String sql = String.format(insertTemplate, tableName, columnName, values);

        return this.connection.prepareStatement(sql).executeUpdate() > 0;
    }

    private String getTableName(E entity) {
        Entity annotation = entity.getClass().getAnnotation(Entity.class);
        if (annotation == null) {
            throw new ORMException("Entities must have @Entity annotation");
        }
        return annotation.name();
    }

    private int getIdFieldValue(E entity, Field idField) throws IllegalAccessException {
        idField.setAccessible(true);
        Object value = idField.get(entity);

        return Integer.parseInt(value.toString());
    }

    private Field getIdField(E entity) {
        Optional<Field> idField = Arrays.stream(entity
                .getClass()
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst();

        if (idField.isEmpty()) {
            throw new ORMException("Entity without @Id field");
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
