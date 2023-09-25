// Assignment: 5
// Author: Ben Levintan, ID: 318181831

package carDealership;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The CarDealership class represents a car dealership program that allows managing employees and cars.
 */
public class CarDealership {
    private static final String CAR_DEALERSHIP_FILE = "C:\\programing\\personal\\assignment5\\src\\CarDealership.txt.txt";
    private static final String SOLD_CARS_FILE = "C:\\programing\\personal\\assignment5\\src\\Sold.txt";
    private static final String EMPLOYEE_FILE = "C:\\programing\\personal\\assignment5\\src\\Employee.txt";

    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();


    /**
     * The main of the CarDealership program.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        loadCars();
        loadEmployees();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    displayUnsoldCars();
                    break;
                case 3:
                    sellCar(scanner);
                    break;
                case 4:
                    addCar(scanner);
                    break;
                case 5:
                    saveUnsoldCars();
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    /**
     * loads a car that the user inputs to the file
     */
    private static void loadCars() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAR_DEALERSHIP_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(" ");
                if (carData.length == 5) {
                    String number = carData[0];
                    int year = Integer.parseInt(carData[1]);
                    String make = carData[2];
                    int mileage = Integer.parseInt(carData[3]);
                    int price = Integer.parseInt(carData[4]);

                    Car car = new Car(number, year, make, mileage, price);
                    cars.add(car);
                }
            }
            System.out.println("Cars loaded successfully.");
        } catch (IOException e) {
            System.out.println("Failed to load cars: " + e.getMessage());
        }
    }
    /**
     * loads Employees data
     */
    private static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(" ");
                if (employeeData.length == 3) {
                    String name = employeeData[0];
                    String id = employeeData[1];
                    int sales = Integer.parseInt(employeeData[2]);

                    Employee employee = new Employee(name, id, sales);
                    employees.add(employee);
                }
            }
            System.out.println("Employees loaded successfully.");
        } catch (IOException e) {
            System.out.println("Failed to load employees: " + e.getMessage());
        }
    }
    /**
     * Prints out the nemu to the program
     */
    private static void displayMenu() {
        System.out.println("Car Dealership Menu");
        System.out.println("1. Display list of employees");
        System.out.println("2. Display unsold cars");
        System.out.println("3. Sell a car");
        System.out.println("4. Add a car to the dealership");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    /**
     * Shows Employees data
     */
    private static void displayEmployees() {
        Collections.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    /**
     * Shows car data
     */
    private static void displayUnsoldCars() {
        for (Car car : cars) {
            if(car != null)
            System.out.println(car);
        }
    }
    /**
     * Sells a car after user choose an Employee
     */
    private static void sellCar(Scanner scanner) {
        displayEmployees();

        System.out.print("Enter the employee ID: ");
        String employeeId = scanner.nextLine();

        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            displayUnsoldCars();

            System.out.print("Enter the car number: ");
            String carNumber = scanner.nextLine();

            Car car = findCarByNumber(carNumber);
            if (car != null) {
//                employee.incrementSales();
                cars.remove(car);

                try (PrintWriter writer = new PrintWriter(new FileWriter(SOLD_CARS_FILE, true))) {
                    writer.println(car);
                    System.out.println("Car sold successfully.");
                } catch (IOException e) {
                    System.out.println("Failed to save sold car: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid car number. Please try again.");
            }
        } else {
            System.out.println("Invalid employee ID. Please try again.");
        }
    }
    /**
     * User adds a car to the unsold list
     */
    private static void addCar(Scanner scanner) {
        System.out.print("Enter the car number: ");
        String number = scanner.nextLine();

        System.out.print("Enter the year of manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        try {
            Car car = new Car(number, year, make, mileage, price);
            cars.add(car);
            System.out.println("Car added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add car: " + e.getMessage());
        }
    }
    /**
     * Finds an employee by their ID.
     * @param id The ID of the employee to find.
     * @return The employee object with the matching ID, or null if not found.
     */
    private static Employee findEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
    /**
     * Finds a car by its number.
     * @param number The number of the car to find.
     * @return The car object with the matching number, or null if not found.
     */
    private static Car findCarByNumber(String number) {
        for (Car car : cars) {
            if (car.getNumber().equals(number)) {
                return car;
            }
        }
        return null;
    }
    /**
     * Saves the unsold cars to the car dealership file.
     * The cars are written to the file in the same format as they were loaded.
     * If an error occurs during the saving process, an error message is printed.
     */
    private static void saveUnsoldCars() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAR_DEALERSHIP_FILE))) {
            for (Car car : cars) {
                writer.println(car);
            }
            System.out.println("Unsold cars saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save unsold cars: " + e.getMessage());
        }
    }
}