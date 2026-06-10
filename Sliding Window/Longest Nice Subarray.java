//https://leetcode.com/problems/longest-nice-subarray/

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i = 0;
        int len = 1; int musk = nums[0];
        for(int j = 1; j < nums.length; j++){
            while((musk & nums[j]) != 0 && i < nums.length){
                musk = musk ^ nums[i];
                i++;    
            }
            musk = musk | nums[j];
            len = Math.max(len, j - i + 1); 
        }
        return len;
    }
}