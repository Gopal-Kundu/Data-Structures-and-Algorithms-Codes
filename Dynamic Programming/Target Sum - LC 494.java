// https://leetcode.com/problems/target-sum/

class Solution {
    int solve(int[][] dp, int[] nums, int idx, int currSum, int target, int sum){
        if(idx == nums.length){
            if(currSum == target) return 1;
            else return 0;
        }
        if(dp[idx][sum - currSum] != 0) return dp[idx][sum - currSum];
        int plus = solve(dp, nums, idx+1, currSum + nums[idx], target, sum);
        int minus = solve(dp, nums, idx+1, currSum - nums[idx], target, sum);
        return dp[idx][sum - currSum] = plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        //target + sum bcz the ans can be negative at max so we incresing sum limit, when ans found we decrese sum.
        int dp[][] = new int[nums.length][sum * 2 + 1];
        return solve(dp, nums, 0, 0, target, sum);
    }
}