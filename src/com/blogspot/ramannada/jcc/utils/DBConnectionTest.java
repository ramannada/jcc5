package com.blogspot.ramannada.jcc.utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DBConnectionTest {
    @Test
    public void getConnection() throws Exception {
        Connection connection = DBConnection.INSTANCE.getConnection();
        System.out.println(connection.getCatalog());
    }

}