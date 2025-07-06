package com.jmc.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/%s";
    private static final String USER = "root";
    private static final String PASSWORD = "23081971";

    public static Connection getConnection(String dbName) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);

        String formattedJdbc = String.format(JDBC_URL, dbName);

        return DriverManager.getConnection(formattedJdbc, props);
    }
}