package Assignment1;

public class Main {
    public static void main(String[] args) {
        dbs.initializeDatabase();

        RentalService rentalService = new RentalService();


        rentalService.addVehicle(new Vehicle("1", "Toyota", "Camry"));
        rentalService.addVehicle(new Vehicle("2", "Honda", "Civic"));
        rentalService.addVehicle(new Vehicle("3", "BMW", "X5"));

        rentalService.addCustomer(new Customer("C1", "Alice", "1234567890"));
        rentalService.addCustomer(new Customer("C2", "Bob", "0987654321"));

        rentalService.displayAvailableVehicles();

        rentalService.rentVehicle(1);

        rentalService.displayAvailableVehicles();

        rentalService.returnVehicle(1);

        rentalService.displayAvailableVehicles();
    }
}


