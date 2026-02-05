package com.zsgs.NoolNikarchi.features.users.serach;



import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.repository.dto.User;

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
            System.out.println("\n=== Search Users ===");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Email");
            System.out.println("3. Search by Mobile");
            System.out.println("4. Back");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        searchByName();
                        break;
                    case 2:
                        searchByEmail();
                        break;
                    case 3:
                        searchByMobile();
                        break;
                    case 4:
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

    private void searchByName() {
        System.out.println("\nEnter name to search:");
        String name = scanner.nextLine();
        model.searchByName(name);
    }

    private void searchByEmail() {
        System.out.println("\nEnter email to search:");
        String email = scanner.nextLine();
        model.searchByEmail(email);
    }

    private void searchByMobile() {
        System.out.println("\nEnter mobile number to search:");
        String mobile = scanner.nextLine();
        model.searchByMobile(mobile);
    }

    public void displayUsers(java.util.List<User> users) {
        if (users.isEmpty()) {
            System.out.println("\nNo users found.");
            return;
        }

        System.out.println("\n=== Search Results ===");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n",
                "User ID", "First Name", "Last Name", "Email", "Mobile");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (User user : users) {
            System.out.printf("%-15s %-20s %-20s %-15s %-15s%n",
                    user.getUserId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getMobileNumber());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
