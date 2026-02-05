package Playground.SD.taxibooking;

import java.util.List;
import java.util.Scanner;

public class TaxiView {

    Scanner sc = new Scanner(System.in);
    TaxiModel model = new TaxiModel();

    public static void main(String[] args) {
        TaxiView view = new TaxiView();
        view.initialize();
    }

    public void initialize() {
        System.out.println("Enter number of taxis:");
        int n = sc.nextInt();
        model.initializeTaxis(n);
        menu();
    }

    private void menu() {
        while (true) {
            System.out.println("\n1.Book Taxi\n2.Display Details\n3.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bookTaxi();
                case 2 -> display();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void bookTaxi() {
        System.out.println("Customer ID:");
        int customerId = sc.nextInt();

        System.out.println("Pickup Point (A-F):");
        char pickup = sc.next().charAt(0);

        System.out.println("Drop Point (A-F):");
        char drop = sc.next().charAt(0);

        System.out.println("Pickup Time:");
        int time = sc.nextInt();

        Taxi taxi = model.getAvailableTaxi(pickup, time);

        if (taxi == null) {
            System.out.println("No taxi available");
            return;
        }

        int distance = Math.abs(pickup - drop);
        int dropTime = time + distance;
        int amount = model.calculateFare(distance);

        taxi.freeTime = dropTime;
        taxi.currentLocation = drop;
        taxi.totalEarning += amount;

        BookingDetails booking = new BookingDetails(
                taxi.bookings.size() + 1,
                customerId,
                pickup,
                drop,
                time,
                dropTime,
                amount
        );

        taxi.bookings.add(booking);

        System.out.println("Taxi " + taxi.taxiNo + " allocated. Fare: " + amount);
    }

    private void display() {
        for (Taxi taxi : model.getTaxis()) {
            System.out.println(taxi);
            for (BookingDetails b : taxi.bookings) {
                System.out.println("  " + b);
            }
        }
    }
}