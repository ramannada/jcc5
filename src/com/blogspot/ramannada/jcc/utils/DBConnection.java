package com.blogspot.ramannada.jcc.utils;

import java.sql.DriverManager;


public class DBConnection {
    private static java.sql.Connection CONNECTION;

    public static final DBConnection INSTANCE = new DBConnection();

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DATABASE_NAME = "jcc";

    {

        try {
            Class.forName(DRIVER).getConstructor().newInstance();
            CONNECTION = DriverManager.getConnection(URL+ DATABASE_NAME, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DBConnection() {
    }

    public java.sql.Connection getConnection() {
        return CONNECTION;
    }


}
