package com.bilgeadam.repository;

import java.util.List;

public interface ICrud<T> {
    void save(T t);

    void update(T t);

    void findAll();

    void deleteById(int id);
}
