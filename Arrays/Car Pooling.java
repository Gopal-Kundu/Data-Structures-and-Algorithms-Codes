//https://leetcode.com/problems/car-pooling/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Line sweep Algorithm used here
        List<int[]> list = new ArrayList<>();
        for (int trip[] : trips) {
            list.add(new int[] { trip[1], trip[0] });
            list.add(new int[] { trip[2], -trip[0] });
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int currCapacity = 0;
        for (int trip[] : list) {
            currCapacity += trip[1];
            if (currCapacity > capacity)
                return false;
        }
        return true;
    }
}