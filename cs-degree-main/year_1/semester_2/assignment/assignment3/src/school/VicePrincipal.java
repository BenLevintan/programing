// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;
/**
 * Represents a vice principal in a school.
 * Inherits from the abstract class Administrator.
 */
public class VicePrincipal extends Administrator {
    /**
     * Creates a new instance of the VicePrincipal class with the specified name, age and salary.
     *
     * @param name the name of the vice principal
     * @param age the age of the vice principal
     * @param salary the salary of the vice principal
     */
    public VicePrincipal (String name, int age, double salary) {
        super(name, age, salary);
    }
    /**
     * Performs work as a vice principal.
     */
    public void work(){
        System.out.println("The vice principal is working .");
    }
    /**
     * Assists the principal in managing the school.
     * Overrides the manage() method in the Administrator class.
     */
    @Override
    public void manage() {
        System.out.println("The vice principal is assisting the principal.");
    }
}
