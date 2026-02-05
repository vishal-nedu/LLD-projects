package Playground.SD.taxibooking;

import java.util.ArrayList;
import java.util.List;

public class TaxiModel {

    private List<Taxi> taxis = new ArrayList<>();

    public void initializeTaxis(int n) {
        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public Taxi getAvailableTaxi(char pickup, int time) {
        Taxi selected = null;

        for (Taxi taxi : taxis) {
            int distance = Math.abs(taxi.currentLocation - pickup);
            int reachableTime = taxi.freeTime + distance;

            if (reachableTime > time) continue;

            if (selected == null ||
                    distance < Math.abs(selected.currentLocation - pickup) ||
                    (distance == Math.abs(selected.currentLocation - pickup)
                            && taxi.freeTime < selected.freeTime) ||
                    (distance == Math.abs(selected.currentLocation - pickup)
                            && taxi.freeTime == selected.freeTime
                            && taxi.totalEarning < selected.totalEarning)) {

                selected = taxi;
            }
        }
        return selected;
    }

    public int calculateFare(int distance) {
        int km = distance * 15;
        return (km - 5) * 10 + 100;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }
}
