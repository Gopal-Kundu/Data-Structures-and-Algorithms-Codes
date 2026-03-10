//https://leetcode.com/problems/find-the-smallest-balanced-index/description/

class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int ans = -1;
        int n = nums.length;
        long[] prefixSum = new long[n];
        
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i]*1L;
            prefixSum[i] = sum - nums[i]*1L;
        }

        long mul = 1;
        for(int i = n-1; i >= 0; i--){
            if(mul == prefixSum[i]) ans = i;
            if(mul > prefixSum[i]) break;
            mul*=nums[i]*1L;
        }
       
        return ans;
    }
}