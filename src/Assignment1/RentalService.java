package Assignment1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalService {

    // Добавление машины в БД
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (brand, model, is_available) VALUES (?, ?, ?)";

        try (Connection conn = dbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehicle.getBrand());
            pstmt.setString(2, vehicle.getModel());
            pstmt.setBoolean(3, vehicle.isAvailable());
            pstmt.executeUpdate();
            System.out.println("Машина добавлена: " + vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Добавление клиента в БД
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (name, phone_number) VALUES (?, ?)";

        try (Connection conn = dbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPhoneNumber());
            pstmt.executeUpdate();
            System.out.println("Клиент добавлен: " + customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Чтение доступных машин из БД
    public void displayAvailableVehicles() {
        String sql = "SELECT * FROM vehicles WHERE is_available = TRUE";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                        String.valueOf(rs.getInt("id")),
                        rs.getString("brand"),
                        rs.getString("model")
                );
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Доступные машины:");
        vehicles.forEach(System.out::println);
    }

    // Аренда машины
    public void rentVehicle(int vehicleId) {
        String sql = "UPDATE vehicles SET is_available = FALSE WHERE id = ?";

        try (Connection conn = dbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehicleId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Машина арендована: " + vehicleId);
            } else {
                System.out.println("Машина не найдена!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Возврат машины
    public void returnVehicle(int vehicleId) {
        String sql = "UPDATE vehicles SET is_available = TRUE WHERE id = ?";

        try (Connection conn = dbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehicleId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Машина возвращена: " + vehicleId);
            } else {
                System.out.println("Машина не найдена!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
