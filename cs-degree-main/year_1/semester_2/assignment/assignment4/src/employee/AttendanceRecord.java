// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package employee;
/**
 * Represents an attendance record for an employee.
 */
public record AttendanceRecord(String ID, int totalWorkingDays, int daysPresent) {
    /**
     * Returns a string representation of the attendance record.
     *
     * @return The string representation of the attendance record.
     */
    @Override
    public String toString() {
        return "AttendanceRecord" +
                "\nID " + ID +
                "\ntotalWorkingDays " + totalWorkingDays +
                "\ndaysPresent " + daysPresent +
                "\nattendancePercentage " + (double) daysPresent / totalWorkingDays * 100;
    }

}
