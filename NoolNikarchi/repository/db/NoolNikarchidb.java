package com.zsgs.NoolNikarchi.repository.db;

import com.zsgs.NoolNikarchi.repository.dto.*;

import java.util.ArrayList;
import java.util.List;

public class NoolNikarchidb
{
    private static NoolNikarchidb noolNikarchidb;
    private List<BorrowRecord> borrowRecords = new ArrayList<>();

    private  NoolNikarchidb() {
    }

    public static  NoolNikarchidb getInstance() {
        if (noolNikarchidb == null) {
            noolNikarchidb = new NoolNikarchidb();
        }
        return noolNikarchidb;
    }

    private RegistrationInfo registrationInfo;
    private Library library;
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public RegistrationInfo getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public boolean validateLoginIngo(String userName, String password) {
        return registrationInfo.getUserName().equals(userName) && registrationInfo.getPassword().equals(password);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public void addUser(User user) {
        users.add(user);
    }
    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
    public Book getBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public User getUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}
