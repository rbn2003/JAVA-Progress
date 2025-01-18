import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;
    private String borrower;
    private LocalDate dueDate;

    public Book(String title, String author) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.borrower = null;
        this.dueDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public String getBorrower() {
        return borrower;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void checkOut(String studentName) {
        if (studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("Borrower's name cannot be null or empty.");
        }
        if (isCheckedOut) {
            throw new IllegalStateException("Book is already checked out.");
        }
        this.isCheckedOut = true;
        this.borrower = studentName;
        this.dueDate = LocalDate.now().plusDays(14); // 2-week borrowing period
    }

    public void turnIn() {
        if (!isCheckedOut) {
            throw new IllegalStateException("Book is not currently checked out.");
        }
        this.isCheckedOut = false;
        this.borrower = null;
        this.dueDate = null;
    }

    @Override
    public String toString() {
        return String.format("Book[title='%s', author='%s', checkedOut=%b, borrower='%s', dueDate='%s']",
                title, author, isCheckedOut, borrower, dueDate);
    }
}
