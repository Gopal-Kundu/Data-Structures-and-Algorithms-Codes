//https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        memo = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target);
    }

    boolean solve(int[] nums, int idx, int target) {
        if (target == 0) return true;
        if (idx == nums.length) return false;

        if (memo[idx][target] != null)
            return memo[idx][target];

        boolean take = false;
        if (target >= nums[idx])
            take = solve(nums, idx + 1, target - nums[idx]);

        boolean notTake = solve(nums, idx + 1, target);

        return memo[idx][target] = take || notTake;
    }
}
