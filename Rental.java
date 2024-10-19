package car;
import java.time.LocalDate;

import car.*;

public class Rental {
    private String rentalId;
    private Car car;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalCost;

    // Constructor
    public Rental(String rentalId, Car car, Customer customer, LocalDate rentalDate, int days) {
        this.rentalId = rentalId;
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = rentalDate.plusDays(days);
        this.totalCost = car.getPricePerDay() * days;
        car.setAvailable(false); // Mark car as rented
    }

    // Method to complete a rental
    public void returnCar() {
        car.setAvailable(true); // Mark car as available
        System.out.println("Car returned. Total cost: " + totalCost);
    }

    // Additional methods
    public static void main(String[] args) {
        
    }
}
