package Assignment1;

import java.sql.Connection;
import java.sql.Statement;

public class dbs {
    public static void initializeDatabase() {
        String createVehiclesTable = "CREATE TABLE IF NOT EXISTS vehicles (" +
                "id SERIAL PRIMARY KEY, " +
                "brand VARCHAR(50) NOT NULL, " +
                "model VARCHAR(50) NOT NULL, " +
                "is_available BOOLEAN DEFAULT TRUE)";

        String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "phone_number VARCHAR(15) NOT NULL)";

        try (Connection conn = dbc.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createVehiclesTable);
            stmt.executeUpdate(createCustomersTable);
            System.out.println("получилось");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("");
        }
    }
}
