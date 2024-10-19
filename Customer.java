package car;
import car.*;
public class Customer {
    private String customerId;
    private String name;
    private String drivingLicense;
    private String phoneNumber;

    // Constructor, Getters, and Setters
    public Customer(String customerId, String name, String drivingLicense, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.drivingLicense = drivingLicense;
        this.phoneNumber = phoneNumber;
    }
    String getCustomerId(){
        return this.customerId;
    }
    String getName(){
        return this.name;
    }

    // Additional methods for customer management
    public static void main(String[] args) {
        
    }
}
