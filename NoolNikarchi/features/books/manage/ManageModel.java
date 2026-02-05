package com.zsgs.NoolNikarchi.features.books.manage;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.Book;

import java.util.List;
import java.util.UUID;

class ManageModel extends BaseModel {

    private final ManageView view;

    public ManageModel(ManageView view) {
        this.view = view;
    }

    void addBook(Book book) {
        if (validateBook(book)) {
            book.setId(generateBookId());
            NoolNikarchidb.getInstance().addBook(book);
            view.showSuccessMessage("Book added successfully!");
        } else {
            view.showErrorMessage("Invalid book information. Please try again.");
        }
    }

    void viewAllBooks() {
        List<Book> books = NoolNikarchidb.getInstance().getAllBooks();
        view.displayBooks(books);
    }

    private boolean validateBook(Book book) {
        return book != null &&
               book.getName() != null && !book.getName().trim().isEmpty() &&
               book.getAuthor() != null && !book.getAuthor().trim().isEmpty() &&
               book.getGenre() != null && !book.getGenre().trim().isEmpty() &&
               book.getVolume() > 0 &&
               book.getPublishedYear() != null && book.getPublishedYear() >= 1800 && book.getPublishedYear() <= 2024 &&
               book.getNoOfCopy() > 0 &&
               book.getAvailableCount() >= 0 && book.getAvailableCount() <= book.getNoOfCopy();
    }

    private String generateBookId() {
        return "BK" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
