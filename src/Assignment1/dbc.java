package Assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbc {
    private static final String URL = "jdbc:postgresql://localhost:5432/rental_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "q1p0w2o9@";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка подключения к базе данных");
        }
    }
}