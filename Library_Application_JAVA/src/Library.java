import java.time.LocalDate;

public class Library {
    private int MAX_BOOKS = 100; // Max capacity of the library
    private Book[] books;
    private int bookCount;

    public Library() {
        this.books = new Book[MAX_BOOKS];
        this.bookCount = 0;
    }

    public int getMAX_BOOKS() {
        return MAX_BOOKS;
    }

    public Book[] getBooks() {
        // Create a compact array of the books currently in the library
        Book[] currentBooks = new Book[bookCount];
        for (int i = 0; i < bookCount; i++) {
            currentBooks[i] = books[i];
        }
        return currentBooks;
    }

    public void addBook(Book book) {
        if (bookCount >= MAX_BOOKS) {
            throw new IllegalStateException("Library is full. Cannot add more books.");
        }
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(book.getTitle()) &&
                    books[i].getAuthor().equals(book.getAuthor())) {
                throw new IllegalStateException("Duplicate book cannot be added.");
            }
        }
        books[bookCount] = book;
        bookCount++;
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        addBook(book);
    }

    public Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        throw new IllegalArgumentException("Book not found in the library.");
    }

    public boolean checkOutBook(String title, String studentName) {
        Book book = findBook(title);
        book.checkOut(studentName);
        return true;
    }



        public boolean returnBook (String title){
            Book book = findBook(title);
            book.turnIn();
            return true;
        }

}
