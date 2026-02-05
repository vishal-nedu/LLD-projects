package com.zsgs.NoolNikarchi.features.books.details;

import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.Book;


import java.util.Optional;

class DetailsModel extends BaseModel {

    private final DetailsView view;

    public DetailsModel(DetailsView view) {
        this.view = view;
    }

    void getBookDetails(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            view.showMessage("Please enter a valid Book ID.");
            return;
        }

        Optional<Book> book = NoolNikarchidb.getInstance().getAllBooks().stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst();

        view.displayBookDetails(book.orElse(null));
    }
}
