//https://leetcode.com/problems/subarrays-with-k-different-integers/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtmostKDistinct(nums, k) - subarraysWithAtmostKDistinct(nums, k-1);
    }
    int subarraysWithAtmostKDistinct(int nums[], int k){
        if(k == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            while(map.size() > k && i < nums.length){
                map.put(nums[i], map.getOrDefault(nums[i], 0)-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }

            if(map.size() <= k) count += j - i + 1;
        }
        return count;
    }
}