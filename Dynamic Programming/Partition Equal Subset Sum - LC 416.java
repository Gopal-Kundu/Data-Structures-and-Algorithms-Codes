https://leetcode.com/problems/partition-equal-subset-sum/description/

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        
        if (totalSum % 2 == 1) // Odd sum can't be partitioned equally
            return false;
        
        int target = totalSum / 2;
        int n = nums.length;
        
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // Exclude current number
                dp[i][j] = dp[i - 1][j];
                
                // Include current number if it doesn't exceed sum
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][target];
    }
}
