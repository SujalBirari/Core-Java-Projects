package OOP.LibraryManagementSystem;

public enum BorrowLimit {
    DAY(1),
    WEEK(7),
    HALF_MONTH(15),
    MONTH(30),
    THREE_MONTHS(90),
    SIX_MONTHS(180),
    YEAR(360);

    private int days;

    BorrowLimit(int i) {}

    public int getDays() { return days; }
}
