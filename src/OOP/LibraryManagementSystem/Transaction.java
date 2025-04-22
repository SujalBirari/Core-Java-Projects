package OOP.LibraryManagementSystem;

import java.time.LocalDate;

public class Transaction {
    private final Member member;
    private final Book book;
    private final LocalDate dateBorrowed;
    private final LocalDate dateToReturn;
    private final int transactionId;

    public Transaction(Member member, Book book, LocalDate dateToReturn, int transactionId) {
        this.member = member;
        this.book = book;
        this.dateBorrowed = LocalDate.now();
        this.dateToReturn = dateToReturn;
        this.transactionId = transactionId;
    }

    public String showTransactionDetails() {
        return "Transaction{" +
                "member=" + member +
                ", book=" + book +
                ", dateBorrowed=" + dateBorrowed +
                ", dateToReturn=" + dateToReturn +
                ", TransactionId=" +  transactionId +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public LocalDate getDateToReturn() {
        return dateToReturn;
    }
}

class ReturnTransaction extends Transaction {
    private final LocalDate dateReturned;
    private final int lateCharges;

    public ReturnTransaction(Member member, Book book, LocalDate dateToReturn, LocalDate dateReturned, int lateCharges, int transactionId) {
        super(member, book, dateToReturn, transactionId);
        this.dateReturned = dateReturned;
        this.lateCharges = lateCharges;
    }

    public String showTransactionDetails() {
        return super.showTransactionDetails() +
                ", dateReturned=" + dateReturned +
                ", lateCharges=" + lateCharges +
                '}';
    }
}
