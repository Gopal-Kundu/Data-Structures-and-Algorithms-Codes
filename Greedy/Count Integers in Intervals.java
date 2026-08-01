//https://leetcode.com/problems/count-integers-in-intervals/

class CountIntervals {
    TreeMap<Integer, Integer> map;
    int total = 0;
    public CountIntervals() {
        map = new TreeMap<>();
    }
    
    public void add(int left, int right) {
        Integer nearestKey = map.floorKey(right);
        if(map.isEmpty() || nearestKey != null && left > map.get(nearestKey)) 
            map.put(left, right);
        else{
            //We have overlapping intervals
            while(nearestKey != null && left <= map.get(nearestKey)){
                int count = map.get(nearestKey) - nearestKey + 1;
                total -= count;
                //New Combined Interval
                left = Math.min(left, nearestKey);
                right = Math.max(right, map.get(nearestKey));
                map.remove(nearestKey);
                nearestKey = map.floorKey(right);
            }
            map.put(left, right);
        }
        
        total += right - left + 1;
    }
    
    public int count() {
        return total;
    }
}
