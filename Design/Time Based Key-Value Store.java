//https://leetcode.com/problems/time-based-key-value-store/

class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    HashMap<String, Integer> trackMaxTimestamp; // max per key
    HashMap<String, Integer> trackMinTimestamp; // min per key

    public TimeMap() {
        map = new HashMap<>();
        trackMaxTimestamp = new HashMap<>();
        trackMinTimestamp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new HashMap<>());
        map.get(key).put(timestamp, value);

        int maxTs = Math.max(trackMaxTimestamp.getOrDefault(key, Integer.MIN_VALUE), timestamp);
        int minTs = Math.min(trackMinTimestamp.getOrDefault(key, Integer.MAX_VALUE), timestamp);
        trackMaxTimestamp.put(key, maxTs);
        trackMinTimestamp.put(key, minTs);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        HashMap<Integer, String> inner = map.get(key);
        int maxTs = trackMaxTimestamp.get(key);
        int minTs = trackMinTimestamp.get(key);

        // Requested time is at/after the largest known timestamp → take the max.
        if (timestamp >= maxTs) return inner.get(maxTs);

        // Requested time is before the smallest known timestamp → nothing to return.
        if (timestamp < minTs) return "";

        // Exact hit.
        if (inner.containsKey(timestamp)) return inner.get(timestamp);

        // Linear scan for the largest existing timestamp ≤ requested.
        int ans = -1;
        for (int i = minTs; i < timestamp; i++) {
            if (inner.containsKey(i)) ans = i;
        }
        return ans == -1 ? "" : inner.get(ans);
    }
}