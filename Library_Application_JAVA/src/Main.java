import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook("Muna Madan", "L.P Devkota");
        library.addBook("The Three's", "Stephen Curry");
        library.addBook("Harry Potter", "J.K Rowling");

        // Check out books
        System.out.println("After checking out books:");
        library.checkOutBook("Muna Madan", "Alice");
        library.checkOutBook("Harry Potter", "Bob");

        // Print all books after checkout
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

        // Return books
        System.out.println("\nAfter returning books:");
        library.returnBook("Muna Madan");

        // Print all books after returning
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}
