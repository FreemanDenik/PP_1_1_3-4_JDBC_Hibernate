package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    static final String hostName = "localhost";
    static final String dbName = "denik_db";
    static final String userName = "root";
    static final String password = "12345";

    public static Connection connectionDB() {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        System.out.println("Get connection...");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("Get: " + connection);
            System.out.println("Done\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
