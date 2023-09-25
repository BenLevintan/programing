package school;
/**
 * Represents an administrator in a school.
 * An administrator is an employee who manages the school's operations.
 */
public abstract class Administrator extends Employee{
    /**
     * Constructs a new Administrator object with the specified name, age, and salary.
     *
     * @param name   the name of the administrator
     * @param age    the age of the administrator
     * @param salary the salary of the administrator
     */
    public Administrator(String name, int age, double salary){
        super(name,age,salary);
    }
    /**
     * Performs management tasks for the school.
     */
    public void manage(){
        // implementation left blank for sub-classes to override
    }
}
