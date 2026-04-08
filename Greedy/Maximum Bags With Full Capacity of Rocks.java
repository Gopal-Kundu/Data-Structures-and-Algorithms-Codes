//https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<int[]> capacityRocks = new ArrayList<>();
        for (int i = 0; i < capacity.length; i++) {
            capacityRocks.add(new int[] { capacity[i], rocks[i] });
        }

        Collections.sort(capacityRocks, (a, b) -> 
        Integer.compare((a[0] - a[1]), (b[0] - b[1])));

        int filled = 0;
        for (int capacityRock[] : capacityRocks) {
            int need = capacityRock[0] - capacityRock[1];
            if (additionalRocks >= need) {
                filled++;
                additionalRocks -= need;
            }
        }
        return filled;
    }
}