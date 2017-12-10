package com.blogspot.ramannada.jcc.dao.impl;

import com.blogspot.ramannada.jcc.dao.MahasiswaDAO;
import com.blogspot.ramannada.jcc.utils.DBConnection;
import com.blogspot.ramannada.jcc.entity.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MahasiswaDAOImpl implements MahasiswaDAO {
    private final String table = "mahasiswa";

    @Override
    public Mahasiswa save(Mahasiswa mahasiswa) {
        String sql = "INSERT INTO "+ table + " (nim, name) VALUES (?,?)";
        try {
            PreparedStatement statement = DBConnection.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2,mahasiswa.getName());
            int isSuccess = statement.executeUpdate();

            if(isSuccess > 0) {
                ResultSet generatedKey = statement.getGeneratedKeys();

                if (generatedKey.next()) {

                   mahasiswa.setId(generatedKey.getInt(1));

                } else {
                    mahasiswa = null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            mahasiswa = null;
        }
        return mahasiswa;
    }

    @Override
    public List<Mahasiswa> getAll() {
        String sql = "SELECT * FROM " + table;
        Statement statement = null;
        List<Mahasiswa> result= new ArrayList<>();

        try {
            statement = DBConnection.INSTANCE.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setId(resultSet.getInt("id"));
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setName(resultSet.getString("name"));

                result.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Mahasiswa findById(Integer id) {
        return null;
    }



    @Override
    public Mahasiswa update(Mahasiswa mahasiswa) {
        String sql = "UPDATE " + table + " SET nim = ?, name = ? WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = DBConnection.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getName());
            statement.setInt(3, mahasiswa.getId());

            int isSuccess = statement.executeUpdate();

            System.out.println(isSuccess);
            if (isSuccess > 0) {
                ResultSet generatedKey = statement.getGeneratedKeys();

            } else {
                mahasiswa = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            mahasiswa = null;
        }


        return mahasiswa;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";

        try {
            PreparedStatement statement = DBConnection.INSTANCE.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            int isSuccess = statement.executeUpdate();

            if (isSuccess > 0) {
                System.out.println("sukses hapus");
            } else {
                System.out.println("Gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mahasiswa findByNim(String nim) {
        String sql = "SELECT * FROM " + table + " WHERE nim = ?";
        Mahasiswa mahasiswa = new Mahasiswa();
        try {
            PreparedStatement statement = DBConnection.INSTANCE.getConnection().prepareStatement(sql);
            statement.setString(1,nim);
            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {


                mahasiswa.setId(resultSet.getInt("id"));
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setName(resultSet.getString("name"));

                return mahasiswa;
            } else {
                mahasiswa = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return mahasiswa;
    }
}
