//https://leetcode.com/problems/house-robber/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int take = nums[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[nums.length-1];
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return solve(nums, dp, nums.length-1);
    }

    // int solve(int nums[], int dp[], int idx){
    //     if(idx <= 0){
    //         if(idx < 0) return 0;
    //         return nums[idx];
    //     }
    //     if(dp[idx] != -1) return dp[idx];
    //     int take = nums[idx] + solve(nums, dp, idx-2);
    //     int notTake = solve(nums, dp, idx-1);
    //     return dp[idx] = Math.max(take, notTake);
    // }
}