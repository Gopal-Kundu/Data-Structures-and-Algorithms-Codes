//https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0; int ans = -10000;
        for(int num : nums){
            sum = Math.max(num, sum+num);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}