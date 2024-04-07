//Ben Levintan
package LibraryPackage;
import java.util.List;
import java.util.ArrayList;

/**
 * A class for managing a library. The underlying data structure for this class minimizes memory use.
 * TODO List for Library Class:

  - [X] Implement a nested 'Book' class:
  -  Creates a new class that represents books in the library.

  - [X] Implement the constructor:
  -  Creates a brand-new library with no books.

  - [X] Implement `addBook(String name, String author)` method:
  -  Adds a new book to the library with a copy quantity of one.

  - [X] Implement `authorWithMostBooks()` method:
  -  Returns the name of the author who wrote the most books in the library.

  - [X] Implement `borrowAllBooks(String authorName)` method:
  -  Borrows all books with the specified author name from the library.

  - [X] Implement `borrowBook(int uniqueID)` method:
  -  Borrows the book with the specified unique ID.

  - [X] Implement `isBorrowed(int uniqueID)` method:
  -  Checks if a book with the specified unique ID is borrowed.

  - [X] Implement `removeBooks(int uniqueID)` method:
  -  Removes a book from the library based on its unique ID.

  - [X] Implement `returnBook(int uniqueID)` method:
  -  Returns a borrowed book with the specified unique ID to the library.

  - [X] Implement `sortedByUniqueID()` method:
  -  Sorts the books in the library according to the unique ID. This method has linear complexity.

  - [X] Implement `totalAvailableBooks()` method:
  -  Returns the total number of books available for loan in the library.

  - [X] Implement `totalBooksInLibrary()` method:
  -  Returns the total number of books in the library.

  - [X] Implement `totalLoanBooks()` method:
  -  Returns the total number of books currently on loan in the library.
 */


public class Library {

    static int idx = 0;
    public DataStructure<Book> books;
    public DataStructure<Book> borrowed_books;
    public Library(){
        this.books = new DataStructure<>();
        this.borrowed_books = new DataStructure<>();
    }

    /**
     * This method borrows all the book from the same author in a library.
     * method is used in sortedByUniqueID()
     *
     * @param author_name is The author of which should be taken out of the library.
     * @return a List with all the books of author_name.
     * */
    public List<Library.Book> borrowAllBooks(String author_name){
        List<Library.Book> authorsBooks = new ArrayList<>();

        for (int i = 0; i < books.size(); ++i)
            if(books.get(i).getAuthor().equals(author_name)) {
                authorsBooks.add(books.get(i));                // add book to the author list
                borrowBook(books.get(i).getuniqueID());        // move said book to borrowed books
                --i;                 // moving index back once, after borrowBook shifts elements to the left
            }
        return authorsBooks;
    }

    /**
     * This method used to find out what is the largest uniqueID book in a library.
     * method is used in sortedByUniqueID()
     *
     * @return the book with the largest uniqueID.
     * */
    public int maxID(){
        int maxID = 0;
        for (int i = 0; i < books.size(); ++i) {
            int currentID = books.get(i).getuniqueID();
            if (currentID > maxID) {
                maxID = currentID;
            }
        }
        return maxID;
    }

    /**
     * Sorting the books in the library according to the unique ID in a decreasing order
     * the method will put the book (in a new DataStructure) in the cell that corresponds with the uniqueID of the book
     * */
    void sortedByUniqueID(){
        int max = maxID();
        DataStructure<Book> temp = new DataStructure<>(max + 1);

        //put book in a cell that is the same as uniqueID
        for(int i = 0; i < books.size(); ++i) {
            Book currentBook = books.get(i);
            temp.add(currentBook, currentBook.getuniqueID());
        }

        //reset books
        books = new DataStructure<>();

        for(int i = 0; i < temp.size(); ++i) {
            Book currentBook = temp.get(temp.size() - i - 1);
            if (currentBook != null) {
                books.addToEnd(currentBook);
            }
        }
    }

    /**
     * Returns the total number of books (on loan and in library).
     *
     * @return the number of all books.
     * */
    int totalBooksInLibrary(){
        return totalLoanBooks() + totalAvailableBooks();
    }

    /**
     * Returns the total number of books that are on a loan.
     *
     * @return the number of loaned books.
     * */
    int totalLoanBooks(){
        int total = 0;
        for(int i = 0; i < borrowed_books.size() ; ++i)
            if (borrowed_books.get(i) != null)
                total++;

        return total;
    }

    /**
     * Returns the total number of books available for loan in the library.
     *
     * @return the number of total books.
     * */
    int totalAvailableBooks(){
        int total = 0;
        for(int i = 0; i < books.size() ; ++i)
            if (books.get(i) != null)
                total++;

        return total;
    }

    /**
     * removes a  borrowed_books in the library ( DataStructure<Book> books )
     * adds that book to books
     *
     * @param uniqueID The book which should be taken out of borrowed_books.
     * @return true if the book is successfully returned; false otherwise.
     * @throws IllegalArgumentException if uniqueID is not found.
     */
    boolean returnBook(int uniqueID){
        for(int i = 0; i < borrowed_books.size() ; ++i)
            if (uniqueID == borrowed_books.get(i).getuniqueID()) {
                books.addToEnd(borrowed_books.get(i));             // add to books
                borrowed_books.delete(borrowed_books.get(i));      // remove from books borrow
                return true;
            }
        System.out.println("Book not found");
        return false;
    }

    /**
     * Checks if a given in borrowed_books
     *
     * @param uniqueID The book which should we check.
     * @return True if book is in borrowed_books otherwise false.
     */
    boolean isBorrowed(int uniqueID){
        for(int i = 0; i < borrowed_books.size(); ++i) {
            if (uniqueID == borrowed_books.get(i).getuniqueID())
                return true;
        }
        return false;
    }

    /**
     * removes a  book in the library ( DataStructure<Book> books )
     * adds that book to borrowed_books
     *
     * @param uniqueID The book which should be taken out of books.
     * @throws IllegalArgumentException if uniqueID is not found.
     */
    public void borrowBook(int uniqueID){
        for(int i = 0; i < books.size() ; ++i)
            if (uniqueID == books.get(i).getuniqueID()) {
                borrowed_books.addToEnd(books.get(i));      // add to borrow books
                books.delete(books.get(i));                 // remove from books
                return;
            }
        throw new IllegalArgumentException("Book was not found.");

    }

    /**
     * adds book to the library ( DataStructure<Book> books )
     *
     * @param name The name of the book which should be added.
     * @param author The name of the author of the book we are adding.
     */
    public void addBook(String name, String author){
        Book newBook = new Book(name , author);
        books.addToEnd(newBook);
    }

    /**
     * Determines the author who has written the most books in the library.
     * this function uses a pseudo hash map structure, created to be efficient
     *
     * @return The name of the author who has written the most books.
     *         Returns null if the library is empty.
     */
    public String authorWithMostBooks(){
        // in case books is empty
        if (books.size() == 0) {
            System.out.println("Library is empty");
            return null;
        }
        String[] authors = new String[books.size()];    // this array will store all the authors in the library
        int[] bookCounts = new int[books.size()];       // this array is parallel to 'authors',
                                                        // each cell represents the number of books created by the author

        String authorWithMostBooks = null;
        int maxBooks = 0;
        // go throw all the books in the library
        for (int i = 0; i < books.size(); i++) {
            // get the author's name
            String author = books.get(i).getAuthor();
            boolean found = false;
            // checks if author already exists in authors
            for (int j = 0; j < authors.length; j++) {
                // if author found, add a book to bookCounts and raise the found flag
                if (authors[j] != null && authors[j].equals(author)) {
                    bookCounts[j]++;
                    found = true;
                    break;
                }
            }
            // if we haven't found the author, add his name to authors
            if (!found) {
                authors[i] = author;
                bookCounts[i] = 1;
            }
        }
        // go throw the bookCounts looking for the max
        // and return the authors name accordingly
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null && bookCounts[i] > maxBooks) {
                maxBooks = bookCounts[i];
                authorWithMostBooks = authors[i];
            }
        }
        return  authorWithMostBooks;
    }

    /**
     * Removes a book from the books array list.
     *
     * @param uniqueID Used to find the book.
     * @throws IllegalArgumentException if the book with the given uniqueID is not found.
     */
    void removeBooks(int uniqueID){
        for(int i = 0; i <= books.size() ; ++i)
            if (uniqueID == books.get(i).getuniqueID()) {
                books.delete(books.get(i));
                return;                     //uniqueID in unique, if removed one action is complete
            }
        throw new IllegalArgumentException("Book was not found.");
        }


    // Nested class representing a book
    public static class Book {
        private String name;
        private String author;

        private final int uniqueID;               // a final int placeholder

        private int quantity;

        // Constructor for Book
        public Book(String name, String author) {
            this.name = name;
            this.author = author;
            this.uniqueID = Library.idx++;                // set an ID number
            this.quantity = 1;              // when Book is created, the quantity is 1 and never changes
        }

        // generic getter setter methods
        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getuniqueID() {
            return uniqueID;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        /**
         * Return the string value of book
         *
         * @return String of the strings inside book.
         */
        public String toString() {
            String str = "";
            str += "[ " + this.name + " by:" + this.author  + "  ID: " + this.uniqueID +"]";
            return str;
        }
    }
}