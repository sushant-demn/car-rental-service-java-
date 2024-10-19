
package car;

import java.util.*;

import car.*;

import java.time.LocalDate;

public class RentalManagement {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public RentalManagement() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String carId, String customerId, int days) {
        Car car = findCarById(carId);
        Customer customer = findCustomerById(customerId);

        if (car != null && car.isAvailable()) {
            Rental rental = new Rental("R" + (rentals.size() + 1), car, customer, LocalDate.now(), days);
            rentals.add(rental);
            System.out.println("Car rented successfully to " + customer.getName());
        } else {
            System.out.println("Car not available or customer not found.");
        }
    }

    private Car findCarById(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean returnCar(String carId) {
        // Find the car by carId
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                // Check if the car is currently rented
                if (!car.isAvailable()) {
                    // Mark the car as available
                    car.setAvailable(true);
                    return true; // Return success
                } else {
                    // The car is not rented
                    return false;
                }
            }
        }
        // If car ID is not found in the system
        return false;
    }
    public static void main(String[] args) {
        
    }

}

