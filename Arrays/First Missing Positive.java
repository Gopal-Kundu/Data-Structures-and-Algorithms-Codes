//https://leetcode.com/problems/first-missing-positive/description/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 0; int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > n || nums[i] <= 0)
                nums[i] = n+1; //As n+1 index is not there.
        }
        for(int i = 0; i < n; i++){
            if(nums[i] == n+1) continue;
            int idx = Math.abs(nums[i]) - 1;
            if (idx < n && nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0) return i+1;
        }
        return n+1;
    }
}