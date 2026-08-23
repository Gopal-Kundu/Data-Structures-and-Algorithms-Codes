https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
      int low = 0, high = nums.length-1;
      int element = 5001;
      while(low <= high){
        int mid = low + (high - low)/2;
        if(nums[low] <= nums[mid]){
            element = Math.min(element, nums[low]);
            low = mid+1;
        }else{
            element = Math.min(element, nums[mid]);
            high = mid-1;
        }
      }  
      return element;
    }
}