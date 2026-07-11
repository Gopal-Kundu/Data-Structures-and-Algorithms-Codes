//https://leetcode.com/problems/subarray-product-less-than-k/description/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 1) return 0;
        int i = 0;
        int prod = 1;
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            prod *= nums[j];
            if(prod >= k){
                while(prod >= k && i < nums.length){
                    prod /= nums[i];
                    i++;
                }
            }
            if(prod < k){
                count += j - i + 1;
            }
        }
        return count;
    }
}