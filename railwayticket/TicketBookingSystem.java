package Playground.SD.railwayticket;

import java.util.Scanner;

public class TicketBookingSystem
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservation reservation = TicketReservation.getInstance();

        while (true) {
            System.out.println("\n--- Railway Ticket Booking ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Confirmed Tickets");
            System.out.println("4. View Available Tickets");
            System.out.println("5. View RAC Tickets");
            System.out.println("6. View Waiting List");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    if (reservation.isFull()) { System.out.println("No tickets available!"); break; }

                    System.out.println("Enter Name:"); String name = sc.nextLine();
                    System.out.println("Enter Age:"); int age = sc.nextInt();
                    System.out.println("Enter Gender (M/F):"); char gender = sc.next().charAt(0);
                    sc.nextLine();
                    System.out.println("Enter Preference (L/M/U):"); String pref = sc.nextLine();
                    System.out.println("Traveling with children? (Y/N):"); String c = sc.nextLine();
                    boolean hasChildren = c.equalsIgnoreCase("Y");

                    Passenger p = reservation.bookTicket(name, age, gender, pref, hasChildren);
                    System.out.println("Ticket Booked: " + p);
                }
                case 2 -> {
                    System.out.println("Enter Ticket ID to Cancel:"); String tid = sc.nextLine();
                    if (reservation.cancelTicket(tid)) System.out.println("Ticket Cancelled Successfully!");
                    else System.out.println("Invalid Ticket ID!");
                }
                case 3 -> reservation.viewConfirmed();
                case 4 -> reservation.viewAvailable();
                case 5 -> reservation.viewRAC();
                case 6 -> reservation.viewWaiting();
                case 7 -> System.exit(0);
            }
        }
    }
}
