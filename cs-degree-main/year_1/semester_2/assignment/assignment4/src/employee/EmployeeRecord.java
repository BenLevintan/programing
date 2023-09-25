// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package employee;
/**
 * Represents an employee record with specific properties.
 */
public record EmployeeRecord(String ID,String name,int age,String department,String designation) {

    /**
     * Returns a string representation of the employee record.
     * @return The string representation of the employee record.
     */
    @Override
    public String toString() {
        return "Employee Record:\n" +
                "ID: " + ID +
                "\nName: " + name +
                "\nAge: " + age +
                "\nDepartment: " + department +
                "\nDesignation: " + designation;
    }

}
