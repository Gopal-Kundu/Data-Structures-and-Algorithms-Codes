//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int i = 0;
        long cnt = 0;
        int maxEle = 0;
        
        for(int j = 0; j < nums.length; j++)
            maxEle = Math.max(maxEle, nums[j]);

        int maxEleFreq = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] == maxEle) maxEleFreq++;
            if(maxEleFreq == k) cnt += nums.length - j;
            while(maxEleFreq == k){
                if(nums[i] == maxEle) maxEleFreq--;
                i++;
                if(maxEleFreq == k) cnt += nums.length - j;
            }
        }
        return cnt;
    }
}