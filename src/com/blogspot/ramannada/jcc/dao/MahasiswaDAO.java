package com.blogspot.ramannada.jcc.dao;

import com.blogspot.ramannada.jcc.entity.Mahasiswa;

public interface MahasiswaDAO extends BaseDAO<Mahasiswa> {
    Mahasiswa findByNim(String nim);
}
