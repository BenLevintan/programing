// Assignment: 5
// Author: Ben Levintan, ID: 318181831


package carDealership;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Represents a car in a car dealership.
 * A car has a number, year, manufacturer, kilometers driven, and price.
 */
public class Car {

    String number;
    int year;
    String manufacture;
    int kilometers;
    int price;

    /**
     * Retrieves the number of the car.
     * @return The number of the car.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number of the car.
     * @param number The number of the car.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Retrieves the year of the car.
     * @return The year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the car.
     * @param year The year of the car.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the manufacturer of the car.
     * @return The manufacturer of the car.
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * Sets the manufacturer of the car.
     * @param manufacture The manufacturer of the car.
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * Retrieves the kilometers driven by the car.
     * @return The kilometers driven by the car.
     */
    public int getKilometers() {
        return kilometers;
    }

    /**
     * Sets the kilometers driven by the car.
     * @param kilometers The kilometers driven by the car.
     */
    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    /**
     * Retrieves the price of the car.
     * @return The price of the car.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the car.
     * @param price The price of the car.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Constructs a new Car object with the specified number, year, manufacturer,
     * kilometers driven, and price.
     * @param number The number of the car.
     * @param year The year of the car.
     * @param manufacture The manufacturer of the car.
     * @param kilometers The kilometers driven by the car.
     * @param price The price of the car.
     * @throws IllegalArgumentException If the car number, price, kilometers, year, or manufacturer is invalid.
     */
    public Car(String number, int year, String manufacture, int kilometers, int price) {
        try {
            if (number.length() != 6) {
                throw new IllegalArgumentException("The car must have a 6-digit number.");
            }
            if (price <= 0) {
                throw new IllegalArgumentException("The price must be positive.");
            }
            if (kilometers < 0) {
                throw new IllegalArgumentException("The kilometers driven must be positive.");
            }
            if (year < 2017 || year > 2023) {
                throw new IllegalArgumentException("The car must be manufactured in 2017 or later (but not from the future).");
            }
            if (manufacture.isEmpty()) {
                throw new IllegalArgumentException("The manufacturer name must not be empty.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid car data: " + e.getMessage());
            return;
        }

        this.number = number;
        this.year = year;
        this.manufacture = manufacture;
        this.kilometers = kilometers;
        this.price = price;
    }

    /**
     * Returns a string representation of the car, including the number, year,
     * manufacturer, kilometers driven, and price.
     * @return A string representation of the car.
     */
    @Override
    public String toString() {
        return number + ' ' + Integer.toString(year) + ' ' + manufacture + ' ' + Integer.toString(kilometers) + ' ' + Integer.toString(price);
    }

    /**
     * Calculates the depreciated value of the car based on a percentage.
     * @param percent The percentage by which the value should be depreciated.
     * @return The depreciated value of the car.
     * @throws IllegalArgumentException If the percentage is negative or the depreciated value exceeds 5000 shekels.
     */
    public int degradeValue(int percent) {
        try {
            if (percent < 0) {
                throw new IllegalArgumentException("The depreciating percentage cannot be negative.");
            }
            if (percent / 100 * price > 5000) {
                throw new IllegalArgumentException("The value cannot depreciate by more than 5000 shekels.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid depreciating percentage: " + e.getMessage());
            return price;
        }

        return price - percent / 100 * price;
    }

    /**
     * Saves the car details to a file.
     * @param writer The FileWriter used to write the car details to the file.
     */
    public void sell(FileWriter writer) {
        try {
            writer.write(toString());
            writer.write("\n"); // Add a new line after each entry
            writer.flush(); // Flush the writer to ensure the data is written to the file
            System.out.println("Car saved to the file.");
        } catch (IOException e) {
            System.out.println("Failed to save car: " + e.getMessage());
        }
    }
}
