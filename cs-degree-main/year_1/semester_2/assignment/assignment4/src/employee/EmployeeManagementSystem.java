// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package employee;
/**
 * A class representing an Employee Management System.
 */
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Create instances of different record types of two employees
        EmployeeRecord employee1 = new EmployeeRecord("312543578", "Bob Belcher", 43, "Sales", "Manager");
        EmployeeRecord employee2 = new EmployeeRecord("521341666", "Homer Simpson", 45, "Marketing", "Coordinator");

        PayrollRecord payroll1 = new PayrollRecord("312543578", 12000, 1000, 2000);
        PayrollRecord payroll2 = new PayrollRecord("521341666", 13000, 1800, 2500);

        LeaveRecord leave1 = new LeaveRecord("312543578", 16, 5);
        LeaveRecord leave2 = new LeaveRecord("521341666", 18, 10);

        AttendanceRecord attendance1 = new AttendanceRecord("312543578", 280, 25);
        AttendanceRecord attendance2 = new AttendanceRecord("521341666", 280, 28);

        // Display information
        System.out.println("\nEmployee 1: \n" + employee1.toString());
        System.out.println("\nEmployee 2: \n" + employee2.toString());

        System.out.println("\nPayroll 1: \n" + payroll1.toString());
        System.out.println("\nPayroll 2: \n" + payroll2.toString());

        System.out.println("\nLeave 1: \n" + leave1.toString());
        System.out.println("\nLeave 2: \n" + leave2.toString());

        System.out.println("\nAttendance 1: \n" + attendance1.toString());
        System.out.println("\nAttendance 2: " + attendance2.toString());
    }

}
