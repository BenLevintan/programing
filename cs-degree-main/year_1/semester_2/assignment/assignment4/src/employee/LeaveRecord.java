// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package employee;
/**
 * Represents a leave record for an employee.
 */
public record LeaveRecord(String ID, int totalLeaves, int leavesTaken) {

    /**
     * Returns a string representation of the leave record.
     * @return The string representation of the leave record.
     */
    @Override
    public String toString(){

        return "LeaveRecord" +
                "\nID " + ID +
                "\ntotalLeaves " + totalLeaves +
                "\nleavesTaken " + leavesTaken +
                "\nremainingLeaves " + String.valueOf(totalLeaves - leavesTaken);
    }

}
