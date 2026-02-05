package com.zsgs.NoolNikarchi.features.borrowbooks;


import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.repository.dto.BorrowRecord;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BorrowBooksView extends BaseView {

    private final BorrowBooksModel model;
    private final Scanner scanner = new Scanner(System.in);

    public BorrowBooksView() {
        model = new BorrowBooksModel(this);
    }

    public void init() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n=== Borrow Books ===");
            System.out.println("1. Borrow Book");
            System.out.println("2. View Borrowed Books");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    model.viewBorrowedBooks();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        model.borrowBook(userId, bookId);
    }

    public void displayBorrowRecords(List<BorrowRecord> records) {
        if (records.isEmpty()) {
            System.out.println("No borrowed books found.");
            return;
        }

        System.out.println("\nBorrow Records:");
        for (BorrowRecord r : records) {
            System.out.println(
                    "Record ID: " + r.getRecordId() +
                            ", User ID: " + r.getUserId() +
                            ", Book ID: " + r.getBookId() +
                            ", Borrowed On: " + new Date(r.getBorrowDate())
            );
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
