package com.jmc.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;

public interface DbContext<E> {
    boolean persist (E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find(Class<E> clazz);
    Iterable<E> find(Class<E> clazz, String where);

    E findFirst(Class<E> clazz) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    E findFirst(Class<E> clazz, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
