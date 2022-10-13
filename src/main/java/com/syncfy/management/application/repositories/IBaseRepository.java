package com.syncfy.management.application.repositories;

import java.util.Optional;

public interface IBaseRepository<T, V> {

    <S extends T> S save(S s);

    Optional<T> findById(V id);

    Iterable<T> findAll();

    void deleteById(V id);
}
