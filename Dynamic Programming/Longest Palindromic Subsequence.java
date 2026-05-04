//https://leetcode.com/problems/longest-palindromic-subsequence/description/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        return solve(dp, s, 0, s.length()-1);
    }

    int solve(int[][] dp, String s, int idx1, int idx2){
        if(idx1 > idx2) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s.charAt(idx1) == s.charAt(idx2)){
            if(idx1 == idx2)
                dp[idx1][idx2] = 1 + solve(dp, s, idx1+1, idx2-1);
            else dp[idx1][idx2] = 2 + solve(dp, s, idx1+1, idx2-1);
        }
        else dp[idx1][idx2] = Math.max(solve(dp, s, idx1+1, idx2), 
        solve(dp, s, idx1, idx2-1));

        return dp[idx1][idx2];    
    }
}