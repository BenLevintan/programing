// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;
/**
 * Represents a support staff member in a school.
 * Inherits from the abstract class Employee.
 */
public abstract class SupportStaff extends Employee{
    /**
     * Creates a new instance of the SupportStaff class with the specified name, age and salary.
     *
     * @param name the name of the support staff member
     * @param age the age of the support staff member
     * @param salary the salary of the support staff member
     */
    public SupportStaff (String name, int age, double salary){
        super(name,age,salary);
    }
    /**
     * Performs support work.
     * This method is abstract and must be implemented by concrete subclasses.
     */
    public void support(){}

}
