package org.example.app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UsersDataBase {

    static Properties prop = new Properties();

    public static Connection connect() {

        Connection conn = null;

        try {
            prop.load(UsersDataBase.class.getResourceAsStream("/db/jdbc.properties"));
            conn = DriverManager.getConnection(prop.getProperty("dbDriver") + prop.getProperty("dbName"),
                    prop.getProperty("username"), prop.getProperty("password"));
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
