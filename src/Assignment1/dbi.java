package Assignment1;

import java.sql.Connection;
import java.sql.Statement;

public class dbi {
    public static void initializeDatabase() {
        String createVehiclesTable = "CREATE TABLE IF NOT EXISTS vehicles (" +
                "id SERIAL PRIMARY KEY, " +
                "brand VARCHAR(50), " +
                "model VARCHAR(50), " +
                "is_available BOOLEAN DEFAULT TRUE)";

        String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "phone_number VARCHAR(15))";

        try (Connection conn = dbc.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createVehiclesTable);
            stmt.execute(createCustomersTable);
            System.out.println("Tables initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
