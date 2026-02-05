package com.zsgs.NoolNikarchi.features.books.search;



import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.features.librarysetup.LibrarySetupView;
import com.zsgs.NoolNikarchi.repository.dto.Book;

import java.util.Scanner;

public class SearchView extends BaseView {
    private final SearchModel model;
    private final Scanner scanner = new Scanner(System.in);

    public SearchView() {
        model = new SearchModel(this);
    }

    public void init() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n=== Search Books ===");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Author");
            System.out.println("3. Search by Genre");
            System.out.println("4. Back to Main Menu");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter book name:");
                        model.searchByName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter author name:");
                        model.searchByAuthor(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter genre:");
                        model.searchByGenre(scanner.nextLine());
                        break;
                    case 4:
                        new LibrarySetupView().showMainMenu();
                        return;
                    case 5:
                        logoutApp();
                        return;
                    case 6:
                        exitApp();
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void displayBooks(java.util.List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("\nNo books found.");
            return;
        }

        System.out.println("\n=== Search Results ===");
        System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (Book book : books) {
            System.out.printf("%-10s %-30s %-20s %-15s %-10d %-10d %-10d%n",
                    book.getId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getVolume(),
                    book.getPublishedYear(),
                    book.getAvailableCount());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
