package com.jmc.orm;

import java.util.Iterator;

public interface DbContext<E> {
    boolean persist (E entity);

    Iterable<E> find(Class<E> clazz);
    Iterable<E> find(Class<E> clazz, String where);

    E findFirst(Class<E> clazz);
    E findFirst(Class<E> clazz, String where);
}
