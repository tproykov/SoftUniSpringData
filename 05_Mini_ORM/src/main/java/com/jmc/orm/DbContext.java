package com.jmc.orm;

import java.sql.SQLException;
import java.util.Iterator;

public interface DbContext<E> {
    boolean persist (E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find(Class<E> clazz);
    Iterable<E> find(Class<E> clazz, String where);

    E findFirst(Class<E> clazz);
    E findFirst(Class<E> clazz, String where);
}
