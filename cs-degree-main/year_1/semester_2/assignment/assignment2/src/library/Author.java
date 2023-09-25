// Assignment: 2
// Author: Ben Levintan, ID: 318181831

package library;


/**
 * The Author class represents an author of a publication.
 * It contains the author's name and email address.
 */
public class Author {

    /**
     * The name of the author.
     */
    private String name;

    /**
     * The email address of the author.
     */
    private String email;

    /**
     * Constructs an author with the specified name and email address.
     *
     * @param name  the name of the author
     * @param email the email address of the author
     */
    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Sets the name of the author.
     *
     * @param name the new name of the author
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the email address of the author.
     *
     * @param email the new email address of the author
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the name of the author.
     *
     * @return the name of the author
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email address of the author.
     *
     * @return the email address of the author
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a string representation of the author.
     *
     * @return a string representation of the author
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Compares this author to the specified author for equality.
     *
     * @param obj the object to compare to
     * @return true if the authors are equal, false otherwise
     */
    public boolean equals(Author obj) {
        return (this.name.equals(obj.name) && this.email.equals(obj.email));
    }
}
