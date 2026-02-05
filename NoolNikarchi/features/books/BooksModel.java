package com.zsgs.NoolNikarchi.features.books;



import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.Book;

import java.util.List;

class BooksModel extends BaseModel {

    private final BooksView view;

    public BooksModel(BooksView view) {
        this.view = view;
    }

    void viewAllBooks() {
        List<Book> books = NoolNikarchidb.getInstance().getAllBooks();
        view.displayBooks(books);
    }
}
