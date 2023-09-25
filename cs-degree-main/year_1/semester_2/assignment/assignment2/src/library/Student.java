// Assignment: 2
// Author: Ben Levintan, ID: 318181831
package library;
/**
 Represents a student with a name, a unique student ID, and a list of loaned publications.
 The student ID is automatically generated and assigned to each new instance of the class.
 */
public class Student {

    /** The name of the student. */
    String studentName;
    /** The number of loaned publications currently held by the student. */
    int loanedNum;
    /** An array of loaned publications held by the student. */
    Publication[] loaned;
    /** A static counter used to generate unique student IDs. */
    static int counter = 0;
    /** The unique ID assigned to the student. */
    public final int STUDENTID;

    /**
     Constructs a new student with the given name and number of loaned publications.
     The student ID is automatically generated and assigned.
     @param studentName the name of the student
     @param loanedNum the number of loaned publications held by the student
     */
    public Student(String studentName, int loanedNum){
        this.studentName = studentName;
        this.loanedNum = loanedNum;
        this.STUDENTID = counter;
        ++counter;
        loaned = new Publication[3];
    }

    /**
     Constructs a new student with the given name and no loaned publications.
     The student ID is automatically generated and assigned.
     @param studentName the name of the student
     */
    public Student(String studentName){
        this.studentName = studentName;
        this.loanedNum = 0;
        this.STUDENTID = counter;
        ++counter;
        loaned = new Publication[3];
    }
    /**
     General getters and setters ofr all vars in the class
     */
    public String getStudentName() {
        return studentName;
    }
    public int getSTUDENTID() {
        return STUDENTID;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public Publication[] getLoaned() {
        return loaned;
    }
    public void setLoaned(Publication[] loaned) {
        this.loaned = loaned;
    }
    public int getLoanedNum() {
        return loanedNum;
    }
    public void setLoanedNum(int loanedNum) {
        this.loanedNum = loanedNum;
    }

    /**
     Returns a string representation of the student, including their ID, name, and list of loaned publications.
     @return a string representation of the student
     */
    @Override
    public String toString() {
        String sb ="";

        sb = sb + "Student number:" + getSTUDENTID() + "name:" +getStudentName() + "\t" + "\nthe student has " + getLoanedNum() +
                " loaned book:\n";

        for(int i = 0 ; i < loanedNum ; ++i){
            sb = sb + loaned[i].toString() + "\n";
        }

        return sb;
    }
}
