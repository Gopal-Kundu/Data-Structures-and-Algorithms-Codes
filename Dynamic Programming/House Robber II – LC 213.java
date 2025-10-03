// https://leetcode.com/problems/house-robber-ii/description/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(maxAfterRob(nums, 0, n-2), maxAfterRob(nums, 1, n-1));
    }

    public int maxAfterRob(int[] nums, int start, int end) {
        int prev = 0, prevMax = 0;
        for(int i=start; i <= end; i++){
            int temp = Math.max(nums[i] + prev, prevMax);
            prev = prevMax;
            prevMax = temp;
        }
        return prevMax;
    }
}