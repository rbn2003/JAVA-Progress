// v3 (Consistent with v2.0 of assignment)

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class Lab9Tests {
    private Library library;
    private final String[] validTitles = {"Test Book", "Another Test Book", "A Third Test Book"};
    private final String[] validAuthors = {"Test Author", "Another Test Author", "A Third Test Author"};
    private final String[] validStudentNames = {"Test Student", "Another Test Student", "A Third Test Student"};

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    // Book Class Tests
    @Nested
    @Order(1)
    class BookTests {
        @Test
        void constructor_WithValidInput_CreatesBook() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            assertEquals(validTitles[0], book.getTitle());
            assertEquals(validAuthors[0], book.getAuthor());
            assertFalse(book.getIsCheckedOut());
            assertNull(book.getBorrower());
            assertNull(book.getDueDate());
        }

        @Test
        void constructor_WithNullTitle_ThrowsException() {
            assertThrows(IllegalArgumentException.class, 
                () -> new Book(null, validAuthors[0]));
        }

        @Test
        void constructor_WithEmptyTitle_ThrowsException() {
            assertThrows(IllegalArgumentException.class, 
                () -> new Book("", validAuthors[0]));
        }

        @Test
        void constructor_WithNullAuthor_ThrowsException() {
            assertThrows(IllegalArgumentException.class, 
                () -> new Book(validTitles[0], null));
        }

        @Test
        void constructor_WithEmptyAuthor_ThrowsException() {
            assertThrows(IllegalArgumentException.class, 
                () -> new Book(validTitles[0], ""));
        }

        @Test
        void checkOut_WithValidStudent_ChecksOutBook() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            book.checkOut(validStudentNames[0]);
            
            assertTrue(book.getIsCheckedOut());
            assertEquals(validStudentNames[0], book.getBorrower());
            assertEquals(LocalDate.now().plusDays(14), book.getDueDate());
        }

        @Test
        void checkOut_WhenAlreadyCheckedOut_ThrowsException() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            book.checkOut(validStudentNames[0]);
            
            assertThrows(IllegalStateException.class, 
                () -> book.checkOut(validStudentNames[0]));
        }

        @Test
        void checkOut_WithNullStudent_ThrowsException() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            assertThrows(IllegalArgumentException.class, 
                () -> book.checkOut(null));
        }

        @Test
        void checkOut_WithEmptyStudent_ThrowsException() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            assertThrows(IllegalArgumentException.class, 
                () -> book.checkOut(""));
        }

        @Test
        void turnIn_CheckedOutBook_ReturnsBook() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            book.checkOut(validStudentNames[0]);
            book.turnIn();
            
            assertFalse(book.getIsCheckedOut());
            assertNull(book.getBorrower());
            assertNull(book.getDueDate());
        }

        @Test
        void turnIn_NotCheckedOutBook_ThrowsException() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            assertThrows(IllegalStateException.class, 
                () -> book.turnIn());
        }

        @Test
        void toString_IncludesAllRequiredInformation() {
            Book book = new Book(validTitles[0], validAuthors[0]);
            String bookString = book.toString();
            // Make sure your toString output contains the title and author!
            assertTrue(bookString.contains(validTitles[0]));
            assertTrue(bookString.contains(validAuthors[0]));
        }
    }

    // Library Class Tests
    @Nested
    @Order(2)
    class LibraryTests {
        @Test
        void constructor_CreatesEmptyLibrary() {
            assertEquals(0, library.getBooks().length);
        }

        @Test
        void addBook_WithBookArgument_WithValidBook_AddsToLibrary() {
            Book validBook = new Book(validTitles[0], validAuthors[0]);
            library.addBook(validBook);
            Book[] books = library.getBooks();

            assertEquals(1, books.length);
            assertEquals(validTitles[0], books[0].getTitle());
            assertEquals(validAuthors[0], books[0].getAuthor());
        }

        @Test
        void addBook_WithBookArgument_DuplicateBook_ThrowsException() {
            Book validBook = new Book(validTitles[0], validAuthors[0]);
            library.addBook(validBook);
            assertThrows(IllegalStateException.class,
                    () -> library.addBook(validTitles[0], validAuthors[0]));
        }

        @Test
        void addBook_WithBookArgument_LibraryFull_ThrowsException() {
            // Make a full array of books to add, filling library to max
            Book[] validBooks = new Book[library.getMAX_BOOKS()];
            for (int i = 0; i < validBooks.length; i++) {
                validBooks[i] = new Book(validTitles[0] + i, validAuthors[0] + i);
            }
            // Fill library to maximum
            for (int i = 0; i < library.getMAX_BOOKS(); i++) {
                library.addBook(validBooks[i]);
            }

            assertThrows(IllegalStateException.class,
                    () -> library.addBook("One More Book", "One More Author"));
        }

        @Test
        void addBook_WithStringArguments_WithValidBook_AddsToLibrary() {
            library.addBook(validTitles[0], validAuthors[0]);
            Book[] books = library.getBooks();
            
            assertEquals(1, books.length);
            assertEquals(validTitles[0], books[0].getTitle());
            assertEquals(validAuthors[0], books[0].getAuthor());
        }

        @Test
        void addBook_WithStringArguments_DuplicateBook_ThrowsException() {
            library.addBook(validTitles[0], validAuthors[0]);
            assertThrows(IllegalStateException.class, 
                () -> library.addBook(validTitles[0], validAuthors[0]));
        }

        @Test
        void addBook_WithStringArguments_LibraryFull_ThrowsException() {
            // Fill library to maximum
            for (int i = 0; i < 1000; i++) {
                library.addBook("Book " + i, "Author " + i);
            }
            
            assertThrows(IllegalStateException.class, 
                () -> library.addBook("One More Book", "One More Author"));
        }

        @Test
        void findBook_ExistingBook_ReturnsBook() {
            library.addBook(validTitles[0], validAuthors[0]);
            Book found = library.findBook(validTitles[0]);
            
            assertEquals(validTitles[0], found.getTitle());
            assertEquals(validAuthors[0], found.getAuthor());
        }

        @Test
        void findBook_NonexistentBook_ThrowsException() {
            assertThrows(IllegalArgumentException.class, 
                () -> library.findBook("Nonexistent Book"));
        }

        @Test
        void checkOutBook_ValidBook_ChecksOutSuccessfully() {
            library.addBook(validTitles[0], validAuthors[0]);
            assertTrue(library.checkOutBook(validTitles[0], validStudentNames[0]));
            
            Book book = library.findBook(validTitles[0]);
            assertTrue(book.getIsCheckedOut());
            assertEquals(validStudentNames[0], book.getBorrower());
        }

        @Test
        void checkOutBook_AlreadyCheckedOut_ThrowsException() {
            library.addBook(validTitles[0], validAuthors[0]);
            library.checkOutBook(validTitles[0], validStudentNames[0]);
            
            assertThrows(IllegalStateException.class, 
                () -> library.checkOutBook(validTitles[0], "Another Student"));
        }

        @Test
        void returnBook_CheckedOutBook_ReturnsSuccessfully() {
            library.addBook(validTitles[0], validAuthors[0]);
            library.checkOutBook(validTitles[0], validStudentNames[0]);
            assertTrue(library.returnBook(validTitles[0]));
            
            Book book = library.findBook(validTitles[0]);
            assertFalse(book.getIsCheckedOut());
            assertNull(book.getBorrower());
        }

        @Test
        void returnBook_NotCheckedOut_ThrowsException() {
            library.addBook(validTitles[0], validAuthors[0]);
            assertThrows(IllegalStateException.class, 
                () -> library.returnBook(validTitles[0]));
        }

        @Test
        void getBooks_ReturnsCompactArray() {
            library.addBook("Book 1", "Author 1");
            library.addBook("Book 2", "Author 2");
            
            Book[] books = library.getBooks();
            assertEquals(2, books.length);
            assertNotNull(books[0]);
            assertNotNull(books[1]);
        }
    }

//    // Stretch Goal Tests
//    @Nested
//    @Order(3)
//    class StretchGoalTests {
//        @Test
//        void findOverdueBooks_ReturnsOverdueBooks() {
//            library.addBook(validTitles[0], validAuthors[0]);
//            library.checkOutBook(validTitles[0], validStudentNames[0]);
//            Book book = library.findBook(validTitles[0]);
//            // Now, make it overdue
//            book.setDueDate(LocalDate.now().minusDays(14)); // make it overdue
//
//            Book[] overdueBooks = library.findOverdueBooks();
//            assertTrue(overdueBooks.length > 0);
//            assertTrue(Arrays.asList(overdueBooks).contains(book));
//        }
//
//        @Test
//        void checkStudentOverdue_WithOverdueBooks_ReturnsTrue() {
//            Book book = new Book(validTitles[0], validAuthors[0]);
//            library.addBook(book);
//            library.checkOutBook(validTitles[0], validStudentNames[0]);
//            // Now, make it overdue
//            book.setDueDate(LocalDate.now().minusDays(15));
//
//            assertTrue(library.checkStudentOverdue(validStudentNames[0]));
//        }
//
//        @Test
//        void studentBooksOverdue_ReturnsOverdueBooks() {
//            Book book1 = new Book(validTitles[0], validAuthors[0]);
//            Book book2 = new Book(validTitles[1], validAuthors[1]);
//            Book book3 = new Book(validTitles[2], validAuthors[2]);
//
//            library.addBook(book1);
//            library.addBook(book2);
//            library.addBook(book3);
//            library.checkOutBook(validTitles[0], validStudentNames[0]);
//            library.checkOutBook(validTitles[2], validStudentNames[0]);
//            // Now, make both books overdue
//
//            book1.setDueDate(LocalDate.now().minusDays(14));
//            book3.setDueDate(LocalDate.now().minusDays(14));
//
//            Book[] overdueBooks = library.studentBooksOverdue(validStudentNames[0]);
//            assertTrue(overdueBooks.length == 2);
//        }
//
//        @Test
//        void findOverdueBooks_NoOverdueBooks_ReturnsEmptyArray() {
//            Book[] overdueBooks = library.findOverdueBooks();
//            assertEquals(0, overdueBooks.length);
//        }
//    }

}
