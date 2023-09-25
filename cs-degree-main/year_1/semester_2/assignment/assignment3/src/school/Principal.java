// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;
/**
 * Represents a principal in a school.
 * Inherits from the abstract class Administrator.
 */
public class Principal extends Administrator{
    /**
     * Creates a new instance of the Principal class with the specified name, age and salary.
     *
     * @param name the name of the principal
     * @param age the age of the principal
     * @param salary the salary of the principal
     */
    public Principal (String name, int age, double salary) {
        super(name, age, salary);
    }
    /**
     * Performs work as a principal.
     */
    public void work(){
        System.out.println("The principal is working .");
    }
    /**
     * Manages the school as a principal.
     * Overrides the manage() method in the Administrator class.
     */
    @Override
    public void manage() {
        System.out.println("The principal is managing the school.");
    }
}
