//https://leetcode.com/problems/concatenate-array-with-reverse/description/

class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[nums.length*2];
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i];
            ans[n*2 - 1 - i] = nums[i];
        }
        return ans;
    }
}