package car;
import car.*;

public class Car {
    private String carId;
    private String model;
    private String make;
    private boolean isAvailable;
    private double pricePerDay;

    // Constructor, Getters, and Setters
    public Car(String carId, String model, String make, double pricePerDay) {
        this.carId = carId;
        this.model = model;
        this.make = make;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true; // Initially, cars are available
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    String getCarId() {
        return this.carId;
    }

    double getPricePerDay() {
        return this.pricePerDay;
    }

    String getMake() {
        return this.make;
    }

    String getModel() {
        return this.model;
    }

    // Additional methods for car management
    public static void main(String[] args) {
        
    }
}
