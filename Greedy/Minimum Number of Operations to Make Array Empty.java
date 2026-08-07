//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);

        int total = 0;
        for(int value : map.values()){
            if(value < 2) return -1;
            total += (value/3);
            if(value%3 != 0) total++;
        }
        return total;
    }
}