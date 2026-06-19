//https://leetcode.com/problems/minimum-replacements-to-sort-the-array/description/

class Solution {
    public long minimumReplacement(int[] nums) {
        int currMax = nums[nums.length-1];
        long minOperation = 0;
        for(int i = nums.length-1; i >= 1; i--){
            if(currMax >= nums[i-1]){
                currMax = nums[i-1];
            }else{
                int parts = nums[i-1]/currMax;
                if(nums[i-1]%currMax != 0) parts++;
                minOperation+=(parts-1)*1L;
                currMax = nums[i-1]/parts;
            }
        }
        return minOperation;
    }
}