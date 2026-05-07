//https://leetcode.com/problems/maximum-score-of-a-good-subarray/

class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k, j = k;
        int minValue = nums[k];
        int maxScore = nums[k];
        while(i > 0 || j < nums.length-1){
            if(i == 0) j++;
            else if(j == nums.length-1) i--;
            else{
                if(nums[i-1] > nums[j+1]) i--;
                else j++;
            }
            minValue = Math.min(minValue, Math.min(nums[i], nums[j]));
            maxScore = Math.max(maxScore, minValue*(j-i+1));
        }
        return maxScore;
    }
}