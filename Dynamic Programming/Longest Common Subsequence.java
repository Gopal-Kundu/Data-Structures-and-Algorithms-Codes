//https://leetcode.com/problems/longest-common-subsequence/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public int solve(int[][] dp, int idx1, int idx2, String text1, String text2){
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
            int max = 0;
                if(text1.charAt(idx1) == text2.charAt(idx2)){
                     max = 1 + solve(dp, idx1-1, idx2-1, text1, text2); 
                }else{
                    max = Math.max(solve(dp, idx1-1, idx2, text1, text2), 
                    solve(dp, idx1, idx2-1, text1, text2));
                }
               

        return dp[idx1][idx2] = max;
    }
}