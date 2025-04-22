package OOP.LibraryManagementSystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Librarian {
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Book> booksInLibrary;
    private static ArrayList<Member> libraryMembers;
    private static ArrayList<Transaction> borrowRecords;
    private static ArrayList<ReturnTransaction> returnRecords;
    private static final int LATE_RETURN_CHARGES = 50;
    private static int transactionId = 1;

    public Librarian() {
        booksInLibrary = new ArrayList<>();
        libraryMembers = new ArrayList<>();
    }

    public void addBook(Book book) {
        booksInLibrary.add(book);
        System.out.println("Book added successfully...");
    }
    public void displayBooks() {
        for (Book book: booksInLibrary) {
            System.out.println(book.toString());
        }
    }
    public void updateBookDetails(int id) {
        Book book = null;
        for (Book book1: booksInLibrary) {
            if (book1.getBookId() == id) {
                book = book1;
                break;
            }
        }

        if (book != null) {
            System.out.print("Enter what detail you want to update: ");
            String detailType = sc.nextLine();

            switch (detailType) {
                case "Name" -> {
                    System.out.print("Enter the updated book title: ");
                    String details = sc.nextLine();
                    book.setBookName(details);
                    System.out.println("Details updated successfully...");
                }
                case "Author" -> {
                    System.out.print("Enter the updated book author name: ");
                    String details = sc.nextLine();
                    book.setBookAuthor(details);
                    System.out.println("Details updated successfully...");
                }
                case "quantity" -> {
                    System.out.print("Enter the updated book quantity: ");
                    int newQuantity = sc.nextInt();
                    book.setQuantity(newQuantity);
                    System.out.println("Details updated successfully...");
                }
                case null, default -> System.out.println("Invalid Input!!!");
            }
        }
        else System.out.println("No book exists in library with given book ID!!!");
    }

    public void removeBook(int id) {
        Book book = null;
        for (Book book1: booksInLibrary) {
            if (book1.getBookId() == id) {
                book = book1;
                break;
            }
        }

        if (book != null) {
            booksInLibrary.remove(book);
            System.out.println("Book removed successfully...");
        }
        else System.out.println("No book exists in library with given book ID!!!");
    }

    public void addReader(Member member) {
        libraryMembers.add(member);
        System.out.println("Reader added successfully...");
    }

    public void removeReaders(int id) {
        Member member = null;
        for (Member member1 : libraryMembers) {
            if (member1.getUserId() == id) {
                member = member1;
                break;
            }
        }

        if (member != null) {
            libraryMembers.remove(member);
            System.out.println("Reader removed successfully...");
        }
        else System.out.println("No such reader with given Id present!!!");
    }

    public void updateUserDetails(int id) {
        Member member = null;
        for (Member member1 : libraryMembers) {
            if (member1.getUserId() == id) {
                member = member1;
                break;
            }
        }

        if (member != null) {
            System.out.print("Enter what detail you want to update: ");
            String detailType = sc.nextLine();

            switch (detailType) {
                case "Name" -> {
                    System.out.print("Enter the updated user name: ");
                    String details = sc.nextLine();
                    member.setName(details);
                    System.out.println("Details updated successfully...");
                }
                case "Email" -> {
                    System.out.print("Enter the updated user email: ");
                    String details = sc.nextLine();
                    member.setEmail(details);
                    System.out.println("Details updated successfully...");
                }
                case null, default -> System.out.println("Invalid Input!!!");
            }
        }
        else System.out.println("No book exists in library with given book ID!!!");
    }

    public void displayReaders() {
        for (Member member : libraryMembers) {
            System.out.println(member.toString());
        }
    }

    public void borrowBook(String member, String title, BorrowLimit borrowLimit) {
        Member member1 = null;
        Book book1 = null;
        for (Member member2: libraryMembers) {
            if (Objects.equals(member2.getName(), member)) {
                member1 = member2;
                break;
            }
        }
        for (Book book: booksInLibrary) {
            if (Objects.equals(book.getBookName(), title)) {
                book1 = book;
                break;
            }
        }

        if (book1 != null) {
            if (book1.getQuantity() > 0) {
                if (member1 != null) {
                    member1.borrowedBooks.add(book1);
                    book1.setQuantity(book1.getQuantity()-1);

                    LocalDate today = LocalDate.now();
                    LocalDate dateToReturn = calculateReturnDate(today, borrowLimit);
                    Transaction record = new Transaction(member1, book1, dateToReturn, transactionId++);
                    borrowRecords.add(record);
                    System.out.println("Book borrowed successfully...");
                }
                else System.out.println("This member is not a reader in this library!");
            }
            else System.out.println("This book has ran out of stocks!");
        }
        else System.out.println("This book is not available in our library!");
    }

    public void returnBook(String member, String title, LocalDate dateReturned, int id) {
        Member member1 = null;
        Book book1 = null;
        LocalDate dateToReturn = null;

        for (Member member2: libraryMembers) {
            if (Objects.equals(member2.getName(), member)) {
                member1 = member2;
                break;
            }
        }
        for (Book book: booksInLibrary) {
            if (Objects.equals(book.getBookName(), title)) {
                book1 = book;
                break;
            }
        }
        for (Transaction transaction: borrowRecords) {
            if (transaction.getTransactionId() == id) {
                dateToReturn = transaction.getDateToReturn();
                break;
            }
        }

        if (book1 != null) {
            if (member1 != null) {
                member1.borrowedBooks.remove(book1);
                book1.setQuantity(book1.getQuantity()+1);
                int lateCharges = calculateLateCharges(dateToReturn, dateReturned);
                ReturnTransaction transaction = new ReturnTransaction(member1, book1, dateToReturn, dateReturned, lateCharges, transactionId++);
                returnRecords.add(transaction);
                System.out.println("Book returned successfully...");
            }
            else System.out.println("This member is not a reader in this library!");
        }
        else System.out.println("This book is not available in our library!");
    }

    private int calculateLateCharges(LocalDate dateToReturn, LocalDate dateReturned) {
        Period period = Period.between(dateToReturn, dateReturned);
        int daysDiff = period.getDays();
        if (daysDiff > 0) return daysDiff*LATE_RETURN_CHARGES;
        else return 0;
    }
    private LocalDate calculateReturnDate(LocalDate dateBorrowed, BorrowLimit borrowLimit) {
        int days = borrowLimit.getDays();
        return dateBorrowed.plusDays(days);
    }

    public void viewMemberBorrowedBooks(String name) {
        Member member = null;
        for (Member member1: libraryMembers) {
            if (Objects.equals(member1.getName(), name)) {
                member = member1;
            }
        }

        if (member != null) {
            for (Book book: member.borrowedBooks) {
                System.out.println(book.toString());
            }
        }
        else System.out.println("This member is not a reader in this library!");
    }
}
