//https://leetcode.com/problems/missing-number/description/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length; int sum = 0;
        for(int i = 0; i < nums.length; i++) sum+= nums[i];
        return (n+1)*n/2 - sum;
    }
}