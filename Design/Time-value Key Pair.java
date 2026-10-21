// https://leetcode.com/problems/time-based-key-value-store/


import java.util.*;

class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timestamps = map.get(key);

        Integer floorTimestamp = timestamps.floorKey(timestamp);

        if (floorTimestamp == null) {
            return "";
        }

        return timestamps.get(floorTimestamp);
    }
}
