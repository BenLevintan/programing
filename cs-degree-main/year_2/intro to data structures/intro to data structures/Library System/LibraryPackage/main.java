//Ben Levintan
package LibraryPackage;
import java.util.List;

//Test file, created to test the methods in Library.java
//this file was created with chatGPT, but changed and modified to work with this program
public class main {

    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add many books to the library
        library.addBook("Sapiens: A Brief History of Humankind", "Yuval Noah Harari");
        library.addBook("12 Rules for Life: An Antidote to Chaos", "Jordan B. Peterson");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones", "James Clear");
        library.addBook("Educated: A Memoir", "Tara Westover");
        library.addBook("The Catcher in the Rye", "J.D. Salinger");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");
        library.addBook("Pride and Prejudice", "Jane Austen");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("Moby Dick", "Herman Melville");
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien");
        library.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
        library.addBook("The Hobbit", "J.R.R. Tolkien");

        // Borrow and return some books to mess up the order
        library.borrowBook(2);
        library.borrowBook(6);
        library.borrowBook(3); // Borrowing a book by author Mark Manson
        library.borrowBook(8);
        library.returnBook(6);
        library.returnBook(2);
        library.borrowBook(10);
        library.borrowBook(12);
        library.returnBook(10);

        // Print all books in the library before sorting
        System.out.println("All books in the library (before sorting):");
        for (int i = 0; i < library.books.size(); i++) {
            System.out.println(library.books.get(i).toString());
        }

        // Sort the books by unique ID
        library.sortedByUniqueID();

        // Print all books in the library after sorting
        System.out.println("\nAll books in the library (after sorting):");
        for (int i = 0; i < library.books.size(); i++) {
            System.out.println(library.books.get(i).toString());
        }

        // Test borrowing a book
        System.out.println("\nTesting borrowing a book:");
        library.borrowBook(1);
        System.out.println("Book with unique ID 1 has been borrowed.");

        // Test returning a book
        System.out.println("\nTesting returning a book:");
        library.returnBook(3);
        System.out.println("Book with unique ID 3 has been returned.");

        // Test total books in the library
        System.out.println("\nTesting total books in the library:");
        System.out.println("Total books in library: " + library.totalBooksInLibrary());

        // Test total available books
        System.out.println("\nTesting total available books:");
        System.out.println("Total available books: " + library.totalAvailableBooks());

        // Test total loan books
        System.out.println("\nTesting total loan books:");
        System.out.println("Total loan books: " + library.totalLoanBooks());

        // Test author with most books
        System.out.println("\nTesting author with most books:");
        String authorWithMostBooks = library.authorWithMostBooks();
        if (authorWithMostBooks != null) {
            System.out.println("Author with most books: " + authorWithMostBooks);
        } else {
            System.out.println("No books in the library.");
        }

        // Test borrowing all books by a specific author
        System.out.println("\nTesting borrowing all books by an author:");
        String authorNameToBorrow = "J.R.R. Tolkien";
        List<Library.Book> borrowedBooksByAuthor = library.borrowAllBooks(authorNameToBorrow);
        System.out.println("Borrowed books by " + authorNameToBorrow + ":");
        for (Library.Book book : borrowedBooksByAuthor) {
            System.out.println(book.toString());
        }

        // Print all books in the library after borrowing by the author
        System.out.println("\nAll books in the library after borrowing by " + authorNameToBorrow + ":");
        for (int i = 0; i < library.books.size(); i++) {
            System.out.println(library.books.get(i).toString());
        }

        // Print all borrowed books
        System.out.println("\nAll borrowed books:");
        for (int i = 0; i < library.borrowed_books.size(); i++) {
            System.out.println(library.borrowed_books.get(i).toString());
        }
    }
}

