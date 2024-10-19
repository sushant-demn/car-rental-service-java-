package car;

import javax.swing.*;

import car.RentalManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarRentalGUI {
    private RentalManagement rentalManagement;

    public CarRentalGUI() {
        rentalManagement = new RentalManagement();
        createMainFrame();
    }

    public void createMainFrame() {
        JFrame frame = new JFrame("Car Rental Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JButton addCarButton = new JButton("Add Car");
        JButton addCustomerButton = new JButton("Add Customer");
        JButton rentCarButton = new JButton("Rent a Car");
        JButton returnCarButton = new JButton("Return a Car");
        JButton viewCarsButton = new JButton("View Available Cars");

        // Add ActionListeners to each button
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

        frame.setVisible(true);
    }

    // Method to display Add Car window
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

        // ActionListener for the button to add the car
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String carId = carIdField.getText();
                String model = modelField.getText();
                String make = makeField.getText();
                double price = Double.parseDouble(priceField.getText());

                // Add the car to the system
                rentalManagement.addCar(new Car(carId, model, make, price));
                JOptionPane.showMessageDialog(addCarFrame, "Car added successfully!");

                addCarFrame.dispose(); // Close window after adding the car
            }
        });

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

    // Similarly, create frames for adding customers, renting cars, returning cars,
    // and viewing cars
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

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdField.getText();
                String name = nameField.getText();
                String license = licenseField.getText();
                String phone = phoneField.getText();

                // Add customer to the system
                rentalManagement.addCustomer(new Customer(customerId, name, license, phone));
                JOptionPane.showMessageDialog(addCustomerFrame, "Customer added successfully!");

                addCustomerFrame.dispose();
            }
        });

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

    private void showRentCarFrame() {
        JFrame rentCarFrame = new JFrame("Rent a Car");
        rentCarFrame.setSize(300, 200);
        rentCarFrame.setLayout(new GridLayout(4, 2));

        // Input fields and labels
        JLabel carIdLabel = new JLabel("Car ID:");
        JTextField carIdField = new JTextField();
        JLabel customerIdLabel = new JLabel("Customer ID:");
        JTextField customerIdField = new JTextField();
        JLabel daysLabel = new JLabel("Number of Days:");
        JTextField daysField = new JTextField();

        // Rent button
        JButton rentButton = new JButton("Rent");

        // Action to be performed when the "Rent" button is clicked
        rentButton.addActionListener(e -> {
            String carId = carIdField.getText();
            String customerId = customerIdField.getText();
            int days = Integer.parseInt(daysField.getText());

            // Call the rentCar() method in RentalManagement to process the rental
            rentalManagement.rentCar(carId, customerId, days);

            // Show success message
            JOptionPane.showMessageDialog(rentCarFrame, "Car rented successfully!");

            // Close the window after renting the car
            rentCarFrame.dispose();
        });

        // Add components to the window
        rentCarFrame.add(carIdLabel);
        rentCarFrame.add(carIdField);
        rentCarFrame.add(customerIdLabel);
        rentCarFrame.add(customerIdField);
        rentCarFrame.add(daysLabel);
        rentCarFrame.add(daysField);
        rentCarFrame.add(rentButton);

        // Display the window
        rentCarFrame.setVisible(true);
    }

    private void showReturnCarFrame() {
        JFrame returnCarFrame = new JFrame("Return a Car");
        returnCarFrame.setSize(300, 150);
        returnCarFrame.setLayout(new GridLayout(2, 2));

        // Components for entering the Car ID
        JLabel carIdLabel = new JLabel("Car ID:");
        JTextField carIdField = new JTextField();

        // Return button
        JButton returnButton = new JButton("Return");

        // Action listener for the return button
        returnButton.addActionListener(e -> {
            String carId = carIdField.getText();

            // Call the method to return the car in RentalManagement
            boolean success = rentalManagement.returnCar(carId);

            // Show success or error message based on the result
            if (success) {
                JOptionPane.showMessageDialog(returnCarFrame, "Car returned successfully!");
            } else {
                JOptionPane.showMessageDialog(returnCarFrame, "Error: Car ID not found or car was not rented!");
            }

            // Close the window after returning the car
            returnCarFrame.dispose();
        });

        // Add components to the return car frame
        returnCarFrame.add(carIdLabel);
        returnCarFrame.add(carIdField);
        returnCarFrame.add(returnButton);

        // Display the window
        returnCarFrame.setVisible(true);
    }

    private void showViewCarsFrame() {
        JFrame viewCarsFrame = new JFrame("Available Cars");
        viewCarsFrame.setSize(500, 300);

        // Column names for the table
        String[] columnNames = { "Car ID", "Model", "Make", "Price Per Day", "Available" };

        // Data for the table
        Object[][] data = new Object[rentalManagement.getCars().size()][5];

        for (int i = 0; i < rentalManagement.getCars().size(); i++) {
            Car car = rentalManagement.getCars().get(i);
            data[i][0] = car.getCarId(); // Car ID
            data[i][1] = car.getModel(); // Model
            data[i][2] = car.getMake(); // Make
            data[i][3] = car.getPricePerDay(); // Price Per Day
            data[i][4] = car.isAvailable() ? "Yes" : "No"; // Availability
        }

        // Creating a table to display the data
        JTable carTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(carTable);

        // Adding the scroll pane (with table) to the frame
        viewCarsFrame.add(scrollPane);

        // Display the window
        viewCarsFrame.setVisible(true);
    }

    // More methods for renting, returning cars, and viewing available cars...
}
