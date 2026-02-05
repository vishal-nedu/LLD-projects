package com.zsgs.NoolNikarchi.features.borrowbooks;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.Book;
import com.zsgs.NoolNikarchi.repository.dto.BorrowRecord;
import com.zsgs.NoolNikarchi.repository.dto.User;

class BorrowBooksModel extends BaseModel {

    private final BorrowBooksView view;

    public BorrowBooksModel(BorrowBooksView view) {
        this.view = view;
    }

    public void borrowBook(String userId, String bookId) {

        NoolNikarchidb db = NoolNikarchidb.getInstance();

        User user = db.getUserById(userId);
        if (user == null) {
            view.showMessage("User not found.");
            return;
        }

        Book book = db.getBookById(bookId);
        if (book == null) {
            view.showMessage("Book not found.");
            return;
        }

        if (book.getAvailableCount() <= 0) {
            view.showMessage("Book not available.");
            return;
        }

        BorrowRecord record = new BorrowRecord();
        record.setRecordId("BRW-" + System.currentTimeMillis());
        record.setUserId(userId);
        record.setBookId(bookId);
        record.setBorrowDate(System.currentTimeMillis());
        record.setReturned(false);

        db.addBorrowRecord(record);
        book.setAvailableCount((byte) (book.getAvailableCount() - 1));

        view.showMessage("Book borrowed successfully!");
    }

    public void viewBorrowedBooks() {
        view.displayBorrowRecords(
                NoolNikarchidb.getInstance().getBorrowRecords()
        );
    }
}
