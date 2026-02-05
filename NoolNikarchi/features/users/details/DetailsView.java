package com.zsgs.NoolNikarchi.features.users.details;



import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.repository.dto.User;

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
            System.out.println("\n=== User Details ===");
            System.out.println("1. View User Details");
            System.out.println("2. Back");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        viewUserDetails();
                        break;
                    case 2:
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

    private void viewUserDetails() {
        System.out.println("\nEnter User ID:");
        String userId = scanner.nextLine();
        model.getUserDetails(userId);
    }

    public void displayUserDetails(User user) {
        if (user == null) {
            System.out.println("\nUser not found.");
            return;
        }

        System.out.println("\n=== User Details ===");
        System.out.println("User ID: " + user.getUserId());
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Mobile: " + user.getMobileNumber());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Date of Birth: " + user.getDob());
    }
}
