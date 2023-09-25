// Assignment: 2
// Author: Ben Levintan, ID: 318181831

package library;
/**
 * A class representing a journal publication.
 * Extends the Publication class and adds properties for issue number and year.
 */
public class Journal extends Publication{
    /**
     * The issue number of the journal.
     */
    int issueNumber;
    /**
     * The year of the journal.
     */
    int year;

    /**
     * Constructs a Journal object with the given properties.
     * @param title the title of the journal
     * @param publisher the publisher of the journal
     * @param qty the quantity of the journal
     * @param issueNumber the issue number of the journal
     * @param year the year of the journal
     */
    public Journal(String title, String publisher, int qty, int issueNumber, int year){
        super(title,publisher,qty);
        this.issueNumber = issueNumber;
        this.year = year;
    }

    /**
     * Returns the issue number of the journal.
     */
    public int getIssueNumber() {
        return issueNumber;
    }
    /**
     * @return the year of the journal
     */
    public int getYear() {
        return year;
    }

    /**
     * Constructs a default Journal object with issue number 1 and year 1970.
     */
    public Journal() {
        this.issueNumber = 1;
        this.year = 1970;
    }

    /**
     * Returns a string representation of the journal.
     */
    @Override
    public String toString() {
        return NUMBER +"-Jrnl\t"+ getTitle() + "(" + issueNumber + ")" + "\n\t\tpublished by " + getPublication() + "(" + year + ")";
    }

}
