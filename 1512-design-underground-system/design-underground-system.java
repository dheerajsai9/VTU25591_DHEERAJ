import java.util.*;

class UndergroundSystem {

    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    Map<Integer, Pair> checkInMap;
    Map<String, int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        checkInMap.remove(id);

        String key = p.station + "-" + stationName;
        int time = t - p.time;

        travelMap.putIfAbsent(key, new int[2]);
        travelMap.get(key)[0] += time;   // total time
        travelMap.get(key)[1] += 1;      // trip count
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] data = travelMap.get(key);
        return (double) data[0] / data[1];
    }
}