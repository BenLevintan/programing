// Assignment: 5
// Author: Ben Levintan, ID: 318181831


package carDealership;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents an employee in a car dealership.
 * An employee has a name, ID, and sales count.
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private String id;
    private int sales;

    /**
     * Retrieves the name of the employee.
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     * @param name The name of the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the ID of the employee.
     * @return The ID of the employee.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the employee.
     * @param id The ID of the employee.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the sales count of the employee.
     * @return The sales count of the employee.
     */
    public int getSales() {
        return sales;
    }

    /**
     * Sets the sales count of the employee.
     * @param sales The sales count of the employee.
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * Constructs a new Employee object with the specified name, ID, and sales count.
     * @param name The name of the employee.
     * @param id The ID of the employee.
     * @param sales The sales count of the employee.
     * @throws IllegalArgumentException If the employee name, ID, or sales count is invalid.
     */
    public Employee(String name, String id, int sales) {
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("The employee name must consist only of letters.");
        }
        if (id.length() != 9 && !id.matches("[0-9]+")) {
            throw new IllegalArgumentException("The employee ID must consist of exactly 9 digits.");
        }
        if (sales < 0) {
            throw new IllegalArgumentException("The number of sales cannot be negative.");
        }

        this.name = name;
        this.id = id;
        this.sales = sales;
    }

    /**
     * Sells a car by incrementing the sales count, removing the car from the file,
     * and saving the updated employee details.
     * @param car The car to be sold.
     * @param writer The FileWriter used to save the updated employee details.
     */
    public void sellCar(Car car, FileWriter writer) {
        try {
            // Increment the sales count
            sales++;

            // Remove the car from the "CarDealership.txt" file
            String filePath = "C:\\programing\\personal\\assignment5\\src\\CarDealership.txt";
            String tempFilePath = "C:\\programing\\personal\\assignment5\\src\\temp.txt";

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writerTemp = new BufferedWriter(new FileWriter(tempFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(" ");
                if (!carData[0].equals(car.getNumber())) {
                    writerTemp.write(line);
                    writerTemp.newLine();
                }
            }

            reader.close();
            writerTemp.close();

            // Replace the original file with the modified one
            java.nio.file.Path originalPath = java.nio.file.Paths.get(filePath);
            java.nio.file.Path tempPath = java.nio.file.Paths.get(tempFilePath);
            java.nio.file.Files.move(tempPath, originalPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            // Save the updated employee details to the file
            writer.write(toString());
            writer.write("\n");
            writer.flush();

            System.out.println("Car sold successfully.");
        } catch (IOException e) {
            System.out.println("Failed to sell car: " + e.getMessage());
        }
    }

    /**
     * Calculates the salary of the employee based on the sales count.
     * @return The calculated salary.
     */
    public int calculateSalary() {
        return 6000 + sales * 100;
    }

    /**
     * Returns a string representation of the employee, including name, ID, sales count, and salary.
     * @return A string representation of the employee.
     */
    @Override
    public String toString() {
        return  name + "  " + id + " " + sales + " " + calculateSalary();
    }

    /**
     * Compares this employee to another employee based on the sales count.
     * @param otherEmployee The other employee to compare to.
     * @return 0 if the sales counts are equal, a negative value if this employee has fewer sales,
     *         a positive value if this employee has more sales.
     */
    @Override
    public int compareTo(Employee otherEmployee) {
        if (otherEmployee.sales == this.sales)
            return 0;
        return -1;
    }
}