package com.blogspot.ramannada.jcc.dao;

import com.blogspot.ramannada.jcc.entity.Jurusan;

public interface JurusanDAO extends BaseDAO<Jurusan> {
    Jurusan findByCode(String code);
}
