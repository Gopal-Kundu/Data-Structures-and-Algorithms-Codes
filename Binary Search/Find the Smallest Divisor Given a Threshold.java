//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int low = 1, high = 1; 
        for(int num : nums) high = Math.max(high, num);
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int val = time(mid, nums);
            if(val <= t){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }

    int time(int mid, int[] nums){
        int t = 0;
        for(int num : nums){
            t += Math.ceil((float)num/mid);
        }
        return t;
    }
}