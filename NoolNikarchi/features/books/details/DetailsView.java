package com.zsgs.NoolNikarchi.features.books.details;
import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.features.librarysetup.LibrarySetupView;
import com.zsgs.NoolNikarchi.repository.dto.Book;



import java.util.Scanner;

public class DetailsView extends BaseView {
    private final DetailsModel model;
    private final Scanner scanner = new Scanner(System.in);

    public DetailsView() {
        model = new DetailsModel(this);
    }

    public void init() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n=== Book Details ===");
            System.out.println("1. View Book Details");
            System.out.println("2. Back to Main Menu");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        viewBookDetails();
                        break;
                    case 2:
                        new LibrarySetupView().showMainMenu();
                        return;
                    case 3:
                        logoutApp();
                        return;
                    case 4:
                        exitApp();
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void viewBookDetails() {
        System.out.println("\nEnter Book ID:");
        String bookId = scanner.nextLine();
        model.getBookDetails(bookId);
    }

    public void displayBookDetails(Book book) {
        if (book == null) {
            System.out.println("\nBook not found.");
            return;
        }

        System.out.println("\n=== Book Details ===");
        System.out.println("Book ID: " + book.getId());
        System.out.println("Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Volume: " + book.getVolume());
        System.out.println("Published Year: " + book.getPublishedYear());
        System.out.println("Total Copies: " + book.getNoOfCopy());
        System.out.println("Available Copies: " + book.getAvailableCount());
    }
}
