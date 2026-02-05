package Playground.SD.railwayticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TicketReservation
{

        private int lb, mb, ub;
        private int totalBerth = 3;
        private int totalRAC = 2;
        private int waitingTickets = 2;

        private int ticketCounter = 0;

        private ArrayList<Passenger> confirmedTickets = new ArrayList<>();
        private ArrayList<Passenger> racTickets = new ArrayList<>();
        private ArrayList<Passenger> waitingList = new ArrayList<>();
        private ArrayList<Passenger> childList = new ArrayList<>();
        private HashMap<String, List<String>> childrenMap = new HashMap<>();

        private static TicketReservation instance = null;
        private Scanner sc = new Scanner(System.in);

        private TicketReservation()
        { divideBerths(); }

        public static TicketReservation getInstance() {
            if (instance == null)
                instance = new TicketReservation();
            return instance;
        }

        private void divideBerths() {
            int g = totalBerth / 3;
            lb = mb = ub = g;
            int rem = totalBerth % 3;
            if (rem >= 1) lb++;
            if (rem == 2) mb++;
        }

        public boolean isFull() { return waitingList.size() >= waitingTickets; }

        public Passenger bookTicket(String name, int age, char gender, String pref, boolean hasChildren) {
            Passenger adult = assignTicket(name, age, gender, pref, age > 60 || (gender == 'F' && age < 12));

            if (adult != null && hasChildren && !adult.berth.equals("Waiting")) {
                System.out.println("Enter number of children:");
                int n = sc.nextInt(); sc.nextLine();
                while (n > 0) {
                    System.out.println("Enter child's name:");
                    String cName = sc.nextLine();
                    System.out.println("Enter child's age:");
                    int cAge = sc.nextInt(); sc.nextLine();
                    System.out.println("Enter child's gender (M/F):");
                    char cGender = sc.nextLine().charAt(0);

                    ticketCounter++;
                    Passenger child = new Passenger("T" + ticketCounter, cName, cAge, cGender, adult.berth);
                    childList.add(child);
                    childrenMap.putIfAbsent(adult.ticketId, new ArrayList<>());
                    childrenMap.get(adult.ticketId).add(child.ticketId);

                    n--;
                }
            }
            return adult;
        }

        private Passenger assignTicket(String name, int age, char gender, String pref, boolean priority) {
            Passenger p = null;

            if (priority && lb > 0 && confirmedTickets.size() < totalBerth) {
                ticketCounter++;
                p = new Passenger("T" + ticketCounter, name, age, gender, "L");
                confirmedTickets.add(p);
                lb--;
                return p;
            }

            // Try preferred berth
            if (pref.equals("L") && lb > 0) { ticketCounter++; p = new Passenger("T" + ticketCounter, name, age, gender, "L"); confirmedTickets.add(p); lb--; }
            else if (pref.equals("M") && mb > 0) { ticketCounter++; p = new Passenger("T" + ticketCounter, name, age, gender, "M"); confirmedTickets.add(p); mb--; }
            else if (pref.equals("U") && ub > 0) { ticketCounter++; p = new Passenger("T" + ticketCounter, name, age, gender, "U"); confirmedTickets.add(p); ub--; }
            else if (racTickets.size() < totalRAC) { ticketCounter++; p = new Passenger("T" + ticketCounter, name, age, gender, "RAC"); racTickets.add(p); }
            else if (waitingList.size() < waitingTickets) { ticketCounter++; p = new Passenger("T" + ticketCounter, name, age, gender, "Waiting"); waitingList.add(p); }

            return p;
        }

        public boolean cancelTicket(String ticketId) {
            Passenger canceled = null;
            for (Passenger p : confirmedTickets) {
                if (p.ticketId.equals(ticketId)) { canceled = p; break; }
            }
            if (canceled == null) return false;

            confirmedTickets.remove(canceled);

            // Remove children if any
            if (childrenMap.containsKey(canceled.ticketId)) {
                List<String> childIds = childrenMap.get(canceled.ticketId);
                childList.removeIf(c -> childIds.contains(c.ticketId));
                childrenMap.remove(canceled.ticketId);
            }

            switch (canceled.berth) {
                case "L" -> lb++;
                case "M" -> mb++;
                case "U" -> ub++;
            }

            // Upgrade RAC -> Confirmed
            if (!racTickets.isEmpty()) {
                Passenger rac = racTickets.remove(0);
                rac.berth = canceled.berth;
                confirmedTickets.add(rac);
                switch (rac.berth) { case "L" -> lb--; case "M" -> mb--; case "U" -> ub--; }
                System.out.println("RAC upgraded to confirmed: " + rac);
            }

            // Upgrade Waiting -> RAC
            if (!waitingList.isEmpty()) {
                Passenger w = waitingList.remove(0);
                w.berth = "RAC";
                racTickets.add(w);
                System.out.println("Waiting upgraded to RAC: " + w);
            }

            return true;
        }

        // Views
        public void viewConfirmed() { confirmedTickets.forEach(System.out::println); }
        public void viewRAC() { racTickets.forEach(System.out::println); }
        public void viewWaiting() { waitingList.forEach(System.out::println); }
        public void viewAvailable() { System.out.println("Available - L: " + lb + ", M: " + mb + ", U: " + ub); }
}

