package lib.GBSeminarsStudy.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class UndergroundSystem {
    private Map<Integer, Passenger> passengers;
    private Map<String, Travel> travelPlaces;

    public UndergroundSystem() {
        passengers = new HashMap<>();
        travelPlaces = new HashMap<>();
    }

    public void checkIn(int id, String stationNameIn, int startTime) {
        passengers.put(id, new Passenger(stationNameIn, startTime));
    }

    public void checkOut(int id, String stationNameOut, int endTime) {
        Passenger currentPassenger = passengers.get(id);
        String stationKey = currentPassenger.getStationName() + "-" + stationNameOut;
        travelPlaces.putIfAbsent(stationKey, new Travel());
        travelPlaces.get(stationKey)
                    .appendTravelTime(endTime-currentPassenger.getTime());
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationKey = startStation + "-" + endStation;
        Travel route = travelPlaces.get(stationKey);
        return (double) route.getTravelSum() / route.getTravelCount();
    }
}
class Passenger {
    private final String stationName;
    private final int startTime;

    public Passenger(String stationName, int t) {
        this.stationName = stationName;
        startTime = t;
    }

    public String getStationName() {
        return stationName;
    }

    public int getTime() {
        return startTime;
    }
}
class Travel {
    //        private List<Integer> travelTimeData;
    private int sum;
    private int count;

    public Travel() {
//            this.travelTimeData = new ArrayList<>();
        this.sum = 0;
        this.count = 0;
    }

    public int getTravelSum() {
        return sum;
    }

    public int getTravelCount() {
        return count;
    }

    public void appendTravelTime(int time) {
//            travelTimeData.add(time);
        sum += time;
        count++;
    }
}
