// Assignment: 2
// Author: Ben Levintan, ID: 318181831
package library;

/**
 The Article class represents a journal article. It extends the Journal class and adds properties such as
 the title of the article, the author of the article, and the URL where the article can be found.
 */
public class Article extends Journal {

    /**
     The title of the article
     */
    private String title;
    /**
     The author of the article
     */
    private Author author;
    /**
     The URL where the article can be found
     */
    private String URL;
    /**
     Constructor for creating an instance of the Article class.
     @param title the title of the article
     @param publisher the publisher of the journal
     @param qty the quantity of the journal
     @param issueNumber the issue number of the journal
     @param year the year of the journal
     @param title1 the title of the article
     @param author the author of the article
     @param URL the URL where the article can be found
     */

    public Article(String title, String publisher, int qty, int issueNumber, int year, String title1, Author author, String URL) {
        super(title, publisher, qty, issueNumber, year);
        this.title = title1;
        this.author = author;
        this.URL = URL;
    }

    /**
     Gets the title of the article
     @return the title of the article
     */
    public String getTitle() {
        return title;
    }

    /**
     Gets the author of the article
     @return the author of the article
     */
    public Author getAuthor() {
        return author;
    }

    /**
     Gets the URL where the article can be found
     @return the URL where the article can be found
     */
    public String getURL() {
        return URL;
    }

    /**
     Returns a string representation of the Article object
     @return a string representation of the Article object
     */
    @Override
    public String toString() {
        return NUMBER + "-Artl\t'" + this.title + "' by " + author.getName() + " at " + author.getEmail() + "\n\t\t" +
                publication + "(" + issueNumber + ")\n\t\t" + URL;
    }
}