package car;
import car.CarRentalGUI;
import car.RentalManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args) {
        new CarRentalGUI(); // Initialize the GUI when the application starts
    }
}

class CarRentalGUI {
    public RentalManagement rentalManagement;  // The core logic behind the app

    public CarRentalGUI() {
        rentalManagement = new RentalManagement(); // Initialize the car rental system
        createMainFrame(); // Create and show the main window
    }

    // Create the main frame with buttons for different actions
    public void createMainFrame() {
        JFrame frame = new JFrame("Car Rental Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        // Create buttons for each action
        JButton addCarButton = new JButton("Add Car");
        JButton addCustomerButton = new JButton("Add Customer");
        JButton rentCarButton = new JButton("Rent a Car");
        JButton returnCarButton = new JButton("Return a Car");
        JButton viewCarsButton = new JButton("View Available Cars");

        // Add action listeners to each button
        addCarButton.addActionListener(e -> showAddCarFrame());
        addCustomerButton.addActionListener(e -> showAddCustomerFrame());
        rentCarButton.addActionListener(e -> showRentCarFrame());
        returnCarButton.addActionListener(e -> showReturnCarFrame());
        viewCarsButton.addActionListener(e -> showViewCarsFrame());

        // Add buttons to the frame
        frame.add(addCarButton);
        frame.add(addCustomerButton);
        frame.add(rentCarButton);
        frame.add(returnCarButton);
        frame.add(viewCarsButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Show a frame to add a car
    private void showAddCarFrame() {
        JFrame addCarFrame = new JFrame("Add Car");
        addCarFrame.setSize(300, 200);
        addCarFrame.setLayout(new GridLayout(5, 2));

        JLabel carIdLabel = new JLabel("Car ID:");
        JTextField carIdField = new JTextField();
        JLabel modelLabel = new JLabel("Model:");
        JTextField modelField = new JTextField();
        JLabel makeLabel = new JLabel("Make:");
        JTextField makeField = new JTextField();
        JLabel priceLabel = new JLabel("Price Per Day:");
        JTextField priceField = new JTextField();

        JButton submitButton = new JButton("Add Car");

        // Action listener to add the car when the button is pressed
        submitButton.addActionListener(e -> {
            String carId = carIdField.getText();
            String model = modelField.getText();
            String make = makeField.getText();
            double price = Double.parseDouble(priceField.getText());

            // Add the car to the rental management system
            rentalManagement.addCar(new Car(carId, model, make, price));
            JOptionPane.showMessageDialog(addCarFrame, "Car added successfully!");
            addCarFrame.dispose(); // Close the window after adding the car
        });

        // Add components to the add car frame
        addCarFrame.add(carIdLabel);
        addCarFrame.add(carIdField);
        addCarFrame.add(modelLabel);
        addCarFrame.add(modelField);
        addCarFrame.add(makeLabel);
        addCarFrame.add(makeField);
        addCarFrame.add(priceLabel);
        addCarFrame.add(priceField);
        addCarFrame.add(submitButton);

        addCarFrame.setVisible(true);
    }

    // Show a frame to add a customer
    private void showAddCustomerFrame() {
        JFrame addCustomerFrame = new JFrame("Add Customer");
        addCustomerFrame.setSize(300, 200);
        addCustomerFrame.setLayout(new GridLayout(5, 2));

        JLabel customerIdLabel = new JLabel("Customer ID:");
        JTextField customerIdField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel licenseLabel = new JLabel("Driving License:");
        JTextField licenseField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();

        JButton submitButton = new JButton("Add Customer");

        // Action listener to add the customer when the button is pressed
        submitButton.addActionListener(e -> {
            String customerId = customerIdField.getText();
            String name = nameField.getText();
            String license = licenseField.getText();
            String phone = phoneField.getText();

            // Add the customer to the rental management system
            rentalManagement.addCustomer(new Customer(customerId, name, license, phone));
            JOptionPane.showMessageDialog(addCustomerFrame, "Customer added successfully!");
            addCustomerFrame.dispose(); // Close the window after adding the customer
        });

        // Add components to the add customer frame
        addCustomerFrame.add(customerIdLabel);
        addCustomerFrame.add(customerIdField);
        addCustomerFrame.add(nameLabel);
        addCustomerFrame.add(nameField);
        addCustomerFrame.add(licenseLabel);
        addCustomerFrame.add(licenseField);
        addCustomerFrame.add(phoneLabel);
        addCustomerFrame.add(phoneField);
        addCustomerFrame.add(submitButton);

        addCustomerFrame.setVisible(true);
    }

    // Show a frame to rent a car
    private void showRentCarFrame() {
        JFrame rentCarFrame = new JFrame("Rent a Car");
        rentCarFrame.setSize(300, 200);
        rentCarFrame.setLayout(new GridLayout(4, 2));

        JLabel carIdLabel = new JLabel("Car ID:");
        JTextField carIdField = new JTextField();
        JLabel customerIdLabel = new JLabel("Customer ID:");
        JTextField customerIdField = new JTextField();
        JLabel daysLabel = new JLabel("Number of Days:");
        JTextField daysField = new JTextField();

        JButton rentButton = new JButton("Rent");

        rentButton.addActionListener(e -> {
            String carId = carIdField.getText();
            String customerId = customerIdField.getText();
            int days = Integer.parseInt(daysField.getText());

            // Rent the car
            rentalManagement.rentCar(carId, customerId, days);
            JOptionPane.showMessageDialog(rentCarFrame, "Car rented successfully!");
            rentCarFrame.dispose(); // Close the window after renting the car
        });

        rentCarFrame.add(carIdLabel);
        rentCarFrame.add(carIdField);
        rentCarFrame.add(customerIdLabel);
        rentCarFrame.add(customerIdField);
        rentCarFrame.add(daysLabel);
        rentCarFrame.add(daysField);
        rentCarFrame.add(rentButton);

        rentCarFrame.setVisible(true);
    }

    // Show a frame to return a car
    private void showReturnCarFrame() {
        JFrame returnCarFrame = new JFrame("Return a Car");
        returnCarFrame.setSize(300, 150);
        returnCarFrame.setLayout(new GridLayout(2, 2));

        JLabel carIdLabel = new JLabel("Car ID:");
        JTextField carIdField = new JTextField();

        JButton returnButton = new JButton("Return");

        returnButton.addActionListener(e -> {
            String carId = carIdField.getText();

            // Implement return car logic
            // In a more advanced implementation, you'd search for the rental
            // and mark the car as available. Here, we'll just display a message.
            JOptionPane.showMessageDialog(returnCarFrame, "Car returned successfully!");
            returnCarFrame.dispose(); // Close the window after returning the car
        });

        returnCarFrame.add(carIdLabel);
        returnCarFrame.add(carIdField);
        returnCarFrame.add(returnButton);

        returnCarFrame.setVisible(true);
    }

    // Show a frame to view all available cars
    private void showViewCarsFrame() {
        JFrame viewCarsFrame = new JFrame("Available Cars");
        viewCarsFrame.setSize(400, 300);

        // Columns for the table
        String[] columnNames = {"Car ID", "Model", "Make", "Price Per Day", "Available"};
        // Prepare the data for the table
        Object[][] data = new Object[rentalManagement.getCars().size()][5];
        for (int i = 0; i < rentalManagement.getCars().size(); i++) {
            Car car = rentalManagement.getCars().get(i);
            data[i][0] = car.getCarId();
            data[i][1] = car.getModel();
            data[i][2] = car.getMake();
            data[i][3] = car.getPricePerDay();
            data[i][4] = car.isAvailable() ? "Yes" : "No";
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        viewCarsFrame.add(scrollPane);
        viewCarsFrame.setVisible(true);
    }
}
