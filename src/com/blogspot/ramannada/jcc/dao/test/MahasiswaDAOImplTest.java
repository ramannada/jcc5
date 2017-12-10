package com.blogspot.ramannada.jcc.dao.test;

import com.blogspot.ramannada.jcc.dao.MahasiswaDAO;
import com.blogspot.ramannada.jcc.dao.impl.MahasiswaDAOImpl;
import com.blogspot.ramannada.jcc.entity.Mahasiswa;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MahasiswaDAOImplTest {
    private MahasiswaDAO mahasiswaDAO = new MahasiswaDAOImpl();

    @Test
    public void save() throws Exception {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim("20171207");
        mahasiswa.setName("anita");

        Mahasiswa result = mahasiswaDAO.save(mahasiswa);

        if (result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("Gagal");
        }
    }

    @Test
    public void findByNim() throws Exception {
        Mahasiswa result = mahasiswaDAO.findByNim("20171201");

        if (result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    @Test
    public void update() throws Exception {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(13);
        mahasiswa.setNim("20171201");
        mahasiswa.setName("jaka");

        Mahasiswa result = mahasiswaDAO.update(mahasiswa);

        if (result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("update gagal");
        }
    }

    @Test
    public void delete() throws Exception {
        mahasiswaDAO.delete(22);
    }

    @Test
    public void getAll() throws Exception {
        List<Mahasiswa> result = mahasiswaDAO.getAll();
        System.out.println(result.size());
    }

}