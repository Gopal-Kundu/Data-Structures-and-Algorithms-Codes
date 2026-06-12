//https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/

class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] == 0){
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 1 ? 0 : 1;
                nums[i+2] = nums[i+2] == 1 ? 0 : 1;
                cnt++;
            }
        }
        int n = nums.length;
        if(nums[n-1] == 0 || nums[n-2] == 0) return -1;
        return cnt;
    }
}