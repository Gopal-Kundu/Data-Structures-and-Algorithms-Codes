//https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, len = (int)1e9;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                if(sum >= target) len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return len == (int)1e9 ? 0 : len;
    }
}