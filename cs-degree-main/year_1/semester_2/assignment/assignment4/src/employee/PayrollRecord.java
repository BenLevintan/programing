// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package employee;
/**
 * Represents a payroll record for an employee.
 */
public record PayrollRecord(String ID, double salary, double bonus, double tax) {
    /**
     * Returns a string representation of the payroll record.
     * @return The string representation of the payroll record.
     */
    @Override
    public String toString() {

        double total = salary + bonus - tax;

        return "Employee Record:" +
                "\nID: " + ID +
                "\nSalary: " + salary +
                "\nBonus: " + bonus +
                "\nTax: " + tax +
                "\nTotal Salary: " + total;
    }
}
