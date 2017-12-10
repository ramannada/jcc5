package com.blogspot.ramannada.jcc.utils;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MariaDB {
    private static MariaDbPoolDataSource mariaDbPoolDataSource;
    private static Connection connection;
    private String url = "jdbc:mysql;localhost/phpmyadmin";
    private String user = "root";
    private String password = "";
    private String driver = "";
    private final String databaseName = "jcc";

    private MariaDB() throws SQLException {
        mariaDbPoolDataSource = new MariaDbPoolDataSource("jdbc:mariadb://server/db?user&maxPoolSize=10");
    }

    public static synchronized MariaDbPoolDataSource getMariaDbPoolDataSource(){
       if (mariaDbPoolDataSource == null) {
           mariaDbPoolDataSource = new MariaDbPoolDataSource();
       }
       return mariaDbPoolDataSource;
    }

    public static Connection getConnection() {
        try {
            return mariaDbPoolDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        mariaDbPoolDataSource.close();
    }
}
