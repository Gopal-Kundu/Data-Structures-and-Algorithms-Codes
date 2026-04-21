//https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0; long longest = -1;
        for(int i = 0; i < nums.length; i++){
            if(i >= 2 && sum > nums[i]){
                longest = sum+nums[i]*1L;
            }
            sum+= nums[i]*1L;
        }
        return longest;
    }
}