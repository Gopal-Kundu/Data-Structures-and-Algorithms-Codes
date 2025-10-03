// https://leetcode.com/problems/delete-and-earn/description/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int track[] = new int[20005];
        int max = 0;
        for(int num : nums){
            track[num]++; max = Math.max(max, num);
        }
        int dp[] = new int[20005];
        dp[1] = track[1]; dp[2] = Math.max(dp[0]+2*track[2], dp[1]);
        for(int i = 3; i <= max; i++){
            dp[i] = Math.max(dp[i-2]+i*track[i], dp[i-1]);
        }
        return dp[max];
    }
}