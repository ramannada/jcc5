package com.blogspot.ramannada.jcc.dao;

import com.blogspot.ramannada.jcc.entity.Entity;

import java.util.List;

public interface BaseDAO<T extends Entity> {

    T save(T entity);

    List<T> getAll();

    T findById(Integer id);

    T update(T entity);

    void delete(Integer id);
}
