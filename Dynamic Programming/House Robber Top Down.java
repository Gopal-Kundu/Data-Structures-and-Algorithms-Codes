// https://leetcode.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, dp, nums.length-1);
    }

    int solve(int nums[], int dp[], int idx){
        if(idx <= 0){
            if(idx < 0) return 0;
            return nums[idx];
        }
        if(dp[idx] != -1) return dp[idx];
        int take = nums[idx] + solve(nums, dp, idx-2);
        int notTake = solve(nums, dp, idx-1);
        return dp[idx] = Math.max(take, notTake);
    }
}