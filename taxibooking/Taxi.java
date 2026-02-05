package Playground.SD.taxibooking;


import java.util.ArrayList;
import java.util.List;

public class Taxi
{
    int taxiNo;
    int totalEarning;
    char currentLocation;
    int freeTime;
    List<BookingDetails> bookings;

    public Taxi(int taxiNo) {
        this.taxiNo = taxiNo;
        this.totalEarning = 0;
        this.currentLocation = 'A';
        this.freeTime = 9;
        this.bookings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiNo=" + taxiNo +
                ", totalEarning=" + totalEarning +
                '}';
    }
}
