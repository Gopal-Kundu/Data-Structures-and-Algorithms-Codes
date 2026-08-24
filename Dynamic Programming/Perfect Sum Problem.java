//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

class Solution {
    // Function to calculate the number of subsets with a given sum
    int[][] memo;
    public int perfectSum(int[] nums, int target) {
        // code here
        memo = new int[nums.length][target+1];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(memo[i], -1);
            
        return solve(nums, target, 0);
    }
    private int solve(int nums[], int target, int idx){
        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }
        
        if(memo[idx][target] != -1) return memo[idx][target];
        
        int pick = 0;
        if(target- nums[idx] >= 0)
            pick = solve(nums, target - nums[idx], idx+1);
        int notPick = solve(nums, target, idx+1);
        
        return memo[idx][target] = pick + notPick;
    }
}