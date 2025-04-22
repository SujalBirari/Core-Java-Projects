package OOP.LibraryManagementSystem;

import java.util.ArrayList;

public class Member {
    private String name;
    private String email;
    private int userId;
    ArrayList<Book> borrowedBooks;

    public Member(String name, String email, int userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
