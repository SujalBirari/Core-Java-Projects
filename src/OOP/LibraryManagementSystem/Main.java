package OOP.LibraryManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int bookId = 1;
    static int userId = 1;

    public static void main(String[] args) {
        Librarian librarian = new Librarian();

        System.out.print("Enter book name: ");
        String bookName = sc.nextLine();
        System.out.print("Enter book author: ");
        String authorName = sc.nextLine();
        System.out.println("Enter the available quantity: ");
        int quantity = sc.nextInt();
        Book book = new Book(bookName, authorName, bookId++, quantity);
        librarian.addBook(book);

        System.out.println("Displaying book records: ");
        librarian.displayBooks();

        System.out.print("Enter the id of book to update details: ");
        int updateId = sc.nextInt();
        librarian.updateBookDetails(updateId);

        System.out.print("Enter the id of book to remove: ");
        int removeId = sc.nextInt();
        librarian.removeBook(removeId);

        System.out.print("Enter user name: ");
        String username = sc.nextLine();
        System.out.print("Enter user email: ");
        String email = sc.nextLine();
        Member member = new Member(username, email, userId++);
        librarian.addReader(member);

        System.out.print("Enter the id of reader to update details: ");
        int userId = sc.nextInt();
        librarian.updateUserDetails(userId);

        System.out.print("Enter the id of reader to remove: ");
        int removeUserId = sc.nextInt();
        librarian.removeReaders(removeUserId);

        System.out.println("Displaying user details: ");
        librarian.displayReaders();

        System.out.print("Enter book title to borrow: ");
        String bookToBorrow = sc.nextLine();
        System.out.print("Enter member name: ");
        String memberToBuyBook = sc.nextLine();
        BorrowLimit borrowLimit = null;
        System.out.print("Please choose a borrow limit: ");
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> borrowLimit = BorrowLimit.DAY;
            case "2" -> borrowLimit = BorrowLimit.WEEK;
            case "3" -> borrowLimit = BorrowLimit.HALF_MONTH;
            case "4" -> borrowLimit = BorrowLimit.MONTH;
            case "5" -> borrowLimit = BorrowLimit.THREE_MONTHS;
            case "6" -> borrowLimit = BorrowLimit.SIX_MONTHS;
            case "7" -> borrowLimit = BorrowLimit.YEAR;
        }
        librarian.borrowBook(memberToBuyBook, bookToBorrow, borrowLimit);

        System.out.print("Enter book title to return: ");
        String bookToReturn = sc.nextLine();
        System.out.print("Enter member name: ");
        String memberReturningBook = sc.nextLine();
        LocalDate dateReturned = null;
        System.out.println("Date returned for the book is: " + dateReturned);
        System.out.print("Enter transaction id of previous borrow: ");
        int id = sc.nextInt();
        librarian.returnBook(memberReturningBook, bookToReturn, null, id);
    }
}
