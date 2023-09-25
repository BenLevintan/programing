// Assignment: 2
// Author: Ben Levintan, ID: 318181831

package library;

/**
 * The Book class represents a book publication.
 */
public class Book extends Publication {
    /**
     * The author of the book.
     */
    Author author;

    /**
     * The editor of the book.
     */
    String editor;

    /**
     * The year the book was published.
     */
    int year;

    /**
     * Constructs a book with the given title, publisher, quantity, author, editor, and year.
     * @param title the title of the book.
     * @param publisher the publisher of the book.
     * @param qty the quantity of the book.
     * @param author the author of the book.
     * @param editor the editor of the book.
     * @param year the year the book was published.
     */
    public Book(String title, String publisher, int qty, Author author, String editor, int year){
        super(title, publisher, qty);
        this.author = author;
        this.editor = editor;
        this.year = year;
    }

    /**
     * Returns the author of the book.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Returns the editor of the book.
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Returns the year the book was published.
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns a string representation of the book.
     */
    @Override
    public String toString() {
        String str;
        str = this.NUMBER + "-Book\t'" + this.title + "' by " + this.author.getName() + " at " + this.author.getEmail() +
                "\n\t\tpublished by " + getPublication() + " edited by ";
        if(editor.equals(""))
            str = str + "unknown";
        else
            str = str + editor;

        return str  + "(" + getYear() + ")";
    }
}
