// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;

/**
 * Represents a janitor in a school.
 * A janitor is a support staff member who maintains the cleanliness and orderliness of the school.
 */
public class Janitor extends SupportStaff {

    /**
     * Constructs a new Janitor object with the specified name, age, and salary.
     *
     * @param name   the name of the janitor
     * @param age    the age of the janitor
     * @param salary the salary of the janitor
     */
    public Janitor(String name, int age, double salary) {
        super(name, age, salary);
    }

    /**
     * Prints a message indicating that the janitor is working.
     */
    public void work() {
        System.out.println("The janitor is working.");
    }

    /**
     * Orders items needed for the school.
     * Overrides the support() method in the SupportStaff class.
     */
    @Override
    public void support() {
        System.out.println("The janitor is ordering the following items:");

        for (int i = 0; i < 9; ++i) {
            System.out.println("Item #" + (i + 1) + "\t\tamount:" + (int) (11 * Math.random()));
        }
        System.out.println("Item #10" + "\tamount:" + (int) (11 * Math.random()));
    }
}
