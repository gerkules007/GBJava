package lib.GBSeminarsStudy.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, Passenger> passengers;
    private Map<String, List<Integer>> travelPlaces;

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
        travelPlaces.getOrDefault( stationKey,
                                   travelPlaces.putIfAbsent(stationKey, new ArrayList<>()) )
                    .add(endTime-currentPassenger.getTime());
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationKey = startStation + "-" + endStation;
        return getAverageTime(travelPlaces.get(stationKey));
    }

    public double getAverageTime(List<Integer> passengerTime) {
        int sum = 0;
        for (int time : passengerTime) {
            sum += time;
        }
        return ((double) sum / passengerTime.size());
    }
    class Passenger {
        private String stationName;
        private int startTime;

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
}
