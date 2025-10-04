// https://leetcode.com/problems/longest-increasing-subsequence/description/

//Brute Force O(N square )
class Solution {
    public int lengthOfLIS(int[] nums) {
       //Dp is for keep track of longest increasing sequence for ith index.
       int dp[] = new int[nums.length];
       Arrays.fill(dp, 1); //In case no increasing sequence

        //using 2 ptr to track increasing sequence.
       for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }    
            }
       }
       int max = 0;
       for(int lens : dp)
        max = Math.max(max, lens);

    return max;
    }
}