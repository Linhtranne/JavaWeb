package com.data.ss8.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/customer";
    private static final String USERNAME = "linhtranne";
    private static final String PASSWORD = "123456";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = java.sql.DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn , CallableStatement callSt) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
        }
    }
}
