package com.zsgs.NoolNikarchi.features.librarysetup;


import com.zsgs.NoolNikarchi.features.base.BaseView;
import com.zsgs.NoolNikarchi.features.librarysetup.details.LibraryDetailsView;
import com.zsgs.NoolNikarchi.repository.dto.Library;

import java.util.Scanner;

public class LibrarySetupView extends BaseView {
    private final LibrarySetupModel model;
    private final Scanner scanner = new Scanner(System.in);

    public LibrarySetupView() {
        model = new LibrarySetupModel(this);
    }

    public void init() {
        model.init();
    }

    public void proceedToSetupLibrary() {
        System.out.println("\n=== Library Setup ===");
        Library library = new Library();
        
        library.setName(getLibraryName());
        library.setAddress(getAddress());
        library.setPhoneNo(getPhoneNumber());
        library.setEmailId(getEmail());
        library.setIncharge(getIncharge());
        library.setCapacity(getCapacity());
        library.setOpeningTime(getOpeningTime());
        library.setClosingTime(getClosingTime());
        library.setNoAvailableDays(getAvailableDays());
        
        model.setupLibrary(library);
    }

    private String getLibraryName() {
        String name = "";
        System.out.println("Enter Library Name:");
        do {
            name = scanner.nextLine();
            if (name.length() < 3 || name.length() > 50)
                System.out.println("Library name should be between 3 and 50 characters\nEnter valid name:");
            else break;
        } while (true);
        return name;
    }

    private String getAddress() {
        String address = "";
        System.out.println("Enter Library Address:");
        do {
            address = scanner.nextLine();
            if (address.length() < 5 || address.length() > 100)
                System.out.println("Address should be between 5 and 100 characters\nEnter valid address:");
            else break;
        } while (true);
        return address;
    }

    private String getPhoneNumber() {
        String phone = "";
        System.out.println("Enter Phone Number:");
        do {
            phone = scanner.nextLine();
            if (!phone.matches("\\d{10}"))
                System.out.println("Phone number should be 10 digits\nEnter valid phone number:");
            else break;
        } while (true);
        return phone;
    }

    private String getEmail() {
        String email = "";
        System.out.println("Enter Email Address:");
        do {
            email = scanner.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                System.out.println("Invalid email format\nEnter valid email:");
            else break;
        } while (true);
        return email;
    }

    private String getIncharge() {
        String incharge = "";
        System.out.println("Enter Library Incharge Name:");
        do {
            incharge = scanner.nextLine();
            if (incharge.length() < 3 || incharge.length() > 50)
                System.out.println("Name should be between 3 and 50 characters\nEnter valid name:");
            else break;
        } while (true);
        return incharge;
    }

    private Integer getCapacity() {
        Integer capacity = null;
        System.out.println("Enter Library Capacity:");
        do {
            try {
                capacity = Integer.parseInt(scanner.nextLine());
                if (capacity <= 0)
                    System.out.println("Capacity should be greater than 0\nEnter valid capacity:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid capacity:");
            }
        } while (true);
        return capacity;
    }

    private Long getOpeningTime() {
        Long time = null;
        System.out.println("Enter Opening Time (in 24-hour format, e.g., 900 for 9:00 AM):");
        do {
            try {
                time = Long.parseLong(scanner.nextLine());
                if (time < 0 || time > 2359)
                    System.out.println("Time should be between 0000 and 2359\nEnter valid time:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid time\nEnter valid time:");
            }
        } while (true);
        return time;
    }

    private Long getClosingTime() {
        Long time = null;
        System.out.println("Enter Closing Time (in 24-hour format, e.g., 1800 for 6:00 PM):");
        do {
            try {
                time = Long.parseLong(scanner.nextLine());
                if (time < 0 || time > 2359)
                    System.out.println("Time should be between 0000 and 2359\nEnter valid time:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid time\nEnter valid time:");
            }
        } while (true);
        return time;
    }

    private Integer getAvailableDays() {
        Integer days = null;
        System.out.println("Enter Number of Available Days per Week (1-7):");
        do {
            try {
                days = Integer.parseInt(scanner.nextLine());
                if (days < 1 || days > 7)
                    System.out.println("Days should be between 1 and 7\nEnter valid days:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid days:");
            }
        } while (true);
        return days;
    }

    public void onLibrarySetupCompleted() {
        System.out.println("\nLibrary setup completed successfully!");
        showMainMenu();
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== LibraSphere Main Menu ===");
            System.out.println("1. Manage Books");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Books");
            System.out.println("4. Manage Users");
            System.out.println("5. View Users");
            System.out.println("6. View Library Details");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        new com.zsgs.NoolNikarchi.features.books.manage.ManageView().init();
                        break;
                    case 2:
                        new com.zsgs.NoolNikarchi.features.books.BooksView().init();
                        break;
                    case 3:
                        new com.zsgs.NoolNikarchi.features.borrowbooks.BorrowBooksView().init();
                    case 4:
                        new com.zsgs.NoolNikarchi.features.users.manage.ManageView().init();
                        break;
                    case 5:
                        new com.zsgs.NoolNikarchi.features.users.UsersView().init();
                        break;
                    case 6:
                        new LibraryDetailsView().init();
                        break;
                    case 7:
                        System.out.println("Logging out...");
                        new com.zsgs.NoolNikarchi.features.registeration.RegistrationView().init();
                        return;
                    case 8:
                        exitApp();
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
        proceedToSetupLibrary();
    }
}
