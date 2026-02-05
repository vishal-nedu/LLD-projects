package com.zsgs.NoolNikarchi.features.librarysetup.details;


import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.features.librarysetup.LibrarySetupView;
import com.zsgs.NoolNikarchi.repository.dto.Library;

import java.util.Scanner;

public class LibraryDetailsView extends BaseView {
    private final LibraryDetailsModel model;
    private final Scanner scanner = new Scanner(System.in);

    public LibraryDetailsView() {
        model = new LibraryDetailsModel(this);
    }

    public void init() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n=== Library Details ===");
            System.out.println("1. View Library Details");
            System.out.println("2. Back to Main Menu");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        model.getLibraryDetails();
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

    public void displayLibraryDetails(Library library) {
        if (library == null) {
            System.out.println("\nLibrary details not found.");
            return;
        }

        System.out.println("\n=== Library Details ===");
        System.out.println("Name: " + library.getName());
        System.out.println("Address: " + library.getAddress());
        System.out.println("Phone: " + library.getPhoneNo());
        System.out.println("Email: " + library.getEmailId());
        System.out.println("Incharge: " + library.getIncharge());
        System.out.println("Capacity: " + library.getCapacity());
        System.out.println("Opening Time: " + formatTime(library.getOpeningTime()));
        System.out.println("Closing Time: " + formatTime(library.getClosingTime()));
        System.out.println("Available Days per Week: " + library.getNoAvailableDays());
    }

    private String formatTime(Long time) {
        if (time == null) return "Not set";
        String timeStr = String.format("%04d", time);
        return timeStr.substring(0, 2) + ":" + timeStr.substring(2);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
} 