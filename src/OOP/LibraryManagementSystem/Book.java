package OOP.LibraryManagementSystem;

public class Book {
    private String bookName;
    private String bookAuthor;
    private final int bookId;
    private int quantity;

    public Book(String bookName, String bookAuthor, int bookId, int quantity) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                '}';
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
