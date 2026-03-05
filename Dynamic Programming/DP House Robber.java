//https://leetcode.com/problems/house-robber/description/

class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        return houseRobber(nums, memo, 0);
    }
    private int houseRobber(int[] nums, int[] memo, int idx){
        if(idx >= nums.length) return 0;

        if(memo[idx] != -1) return memo[idx];
        int rob = nums[idx] + houseRobber(nums, memo, idx+2);
        int skip = houseRobber(nums, memo, idx+1);
        return memo[idx] = Math.max(rob , skip);
    }
}