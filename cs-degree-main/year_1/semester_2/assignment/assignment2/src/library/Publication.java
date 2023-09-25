// Assignment: 2
// Author: Ben Levintan, ID: 318181831

package library;

import java.util.Arrays;
import java.util.Objects;

public class Publication {

    /** The title of the publication */
    String title;

    /** The name of the publication */
    String publication;

    /** The number of copies of the publication */
    int qty;

    /** A unique number assigned to the publication */
    public final int NUMBER;

    /** A counter to keep track of the number of publications */
    static int counter = 0;

    /**
     * Constructs a Publication object with the specified title, publication, and quantity.
     * @param title The title of the publication.
     * @param publication The name of the publication.
     * @param qty The number of copies of the publication.
     */
    public Publication(String title, String publication, int qty){
        
        this.title=title;
        this.publication=publication;
        this.qty=qty;
        this.NUMBER = 10 + counter;
        counter++;

    }

    /**
     * Constructs a Publication object with default values.
     */
    public Publication() {
        this.title = "";
        this.publication = "";
        this.qty = 0;
        this.NUMBER = 10 + counter;
        counter++;
    }
    /**
     * Gets the title of the publication.
     * @return The title of the publication.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Gets the name of the publication.
     * @return The name of the publication.
     */
    public String getPublication() {
        return publication;
    }
    /**
     * Gets the number of copies of the publication.
     * @return The number of copies of the publication.
     */
    public int getQty() {
        return qty;
    }
    /**
     * Gets the publication number.
     * @return The publication number.
     */
    public int getNUMBER() {
        return NUMBER;
    }
    /**
     * Gets the counter value.
     * @return The counter value.
     */
    public static int getCounter() {
        return counter;
    }
    /**
     * Sets the number of copies of the publication.
     * @param qty The number of copies of the publication.
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    /**
     * Sets the title of the publication.
     * @param title The title of the publication.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Sets the name of the publication.
     * @param publication The name of the publication.
     */
    public void setPublication(String publication) {
        this.publication = publication;
    }
    /**
     * Sets the counter value.
     * @param counter The counter value.
     */
    public static void setCounter(int counter) {
        Publication.counter = counter;
    }
    /**
     * Returns a string representation of the publication.
     */
    @Override
    public String toString() {
        return "Publication{title='" + title + "', publication='" + publication + "', number of copies=" + qty + ", NUMBER=" + NUMBER + "}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o The reference object with which to compare.
     * @return true if this object is the same as the o argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return qty == that.qty && NUMBER == that.NUMBER && Objects.equals(title, that.title) && Objects.equals(publication, that.publication);
    }


    /**
     * sorts and array of publications.
     * @param old The reference array before it is sorted.
     */
    public static void sort(Publication[] old){

        Publication[] sorted = new Publication[old.length];
        counter=0;

        int newIndex = 0;

        // sort the books first
        for(int i = 0; old[i]!=null ; ++i){
            counter =+ i;
            if (old[i] instanceof Book){
                sorted[newIndex] = new Book(old[i].getTitle(), old[i].getPublication(), old[i].getQty(),((Book) old[i]).getAuthor(),((Book) old[i]).getEditor(),((Book) old[i]).getYear());
                ++newIndex;
            }
        }
        //sort the Journals second
        for(int i = 0; old[i]!=null ; ++i){
             counter =+ i;
            if (old[i] instanceof Journal && !(old[i] instanceof Article)){
                sorted[newIndex] = new Journal(old[i].title, old[i].publication, old[i].qty, ((Journal) old[i]).getIssueNumber(), ((Journal) old[i]).getYear());
                ++newIndex;
            }
        }
        // Then, sort the articles
        for (int i = 0; old[i] != null; ++i) {
            counter =+ i;
            if (old[i] instanceof Article) {
                sorted[newIndex] = new Article(old[i].getTitle(), old[i].getPublication(), old[i].getQty(),
                        ((Journal) old[i]).getIssueNumber(), ((Journal) old[i]).getYear(),
                        ((Article) old[i]).getTitle(), ((Article) old[i]).getAuthor(), ((Article) old[i]).getURL());
                ++newIndex;
            }
        }

        // Then, sort the encyclopedias
        for (int i = 0; old[i] != null; ++i) {
            counter =+ i;
            if (old[i] instanceof Encyclopedia) {
                sorted[newIndex] = new Encyclopedia(old[i].getTitle(), old[i].getPublication(), old[i].getQty(),
                        ((Encyclopedia) old[i]).getEditor(), ((Encyclopedia) old[i]).getVolume());
                ++newIndex;
            }
        }

        //copy the sorted array to the old one
        for(int i = 0 ; sorted[i]!=null ;++i){
            old[i]=sorted[i];
        }

    }

}
