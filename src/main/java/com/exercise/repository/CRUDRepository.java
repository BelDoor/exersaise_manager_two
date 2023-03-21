package com.exercise.repository;

import java.util.List;

public interface CRUDRepository <K, T> {
    T findOne(K id);

    List<T> findAll();

    T create(T object);

    T update(K id, T object);

    void delete(K id);
}
