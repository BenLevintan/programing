// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;

/**
 * Represents a secretary in a school.
 * A secretary is a support staff member who performs administrative tasks.
 */
public class Secretary extends SupportStaff{
    /**
     * Constructs a new Secretary object with the specified name, age, and salary.
     *
     * @param name   the name of the secretary
     * @param age    the age of the secretary
     * @param salary the salary of the secretary
     */
    public Secretary (String name, int age, double salary){
        super(name, age, salary);
    }
    /**
     * Prints a message indicating that the secretary is working.
     */
    public void work(){
        System.out.println("The secretary is working .");

    }
    /**
     * Enters grades into Moodle for 30 students.
     * Overrides the support() method in the SupportStaff class.
     */
    @Override
    public void support(){

        System.out.println("The secretary enters the following grades into moodle:");

        for (int i = 0; i < 30; ++i) {
            System.out.println("Student#" + i + "\tgrade:" + (int) (101 * Math.random()));
        }

    }

}
