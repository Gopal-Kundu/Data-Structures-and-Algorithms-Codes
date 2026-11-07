//https://leetcode.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        return solve(nums, nums.length-1);
    }

    int solve(int nums[], int idx){
        if(idx <= 0){
            if(idx < 0) return 0;
            return nums[idx];
        }
        int take = nums[idx] + solve(nums, idx-2);
        int notTake = solve(nums, idx-1);
        return Math.max(take, notTake);
    }
}