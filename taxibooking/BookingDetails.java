package Playground.SD.taxibooking;

public class BookingDetails {
    int bookingId;
    int customerId;
    char from;
    char to;
    int pickupTime;
    int dropTime;
    int amount;

    public BookingDetails(int bookingId, int customerId, char from, char to,
                          int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", from=" + from +
                ", to=" + to +
                ", pickupTime=" + pickupTime +
                ", dropTime=" + dropTime +
                ", amount=" + amount +
                '}';
    }
}
