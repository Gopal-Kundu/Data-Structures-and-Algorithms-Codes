//https://www.geeksforgeeks.org/problems/rod-cutting0840/1

class Solution {
    public int cutRod(int[] price) {
        // code here
        int rodLength = price.length;
        int dp[][] = new int[rodLength+1][price.length];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                // i is rodLength and j is idx
                int cut = 0;
                int notCut = 0;
                if(i >= j+1)
                    cut = price[j] + dp[i - (j+1)][j];
                if(j > 0) notCut = dp[i][j-1];
                
                dp[i][j] = Math.max(cut, notCut);
            }
        }
    
        return dp[rodLength][price.length-1];
    }
    
    int solve(int[][] dp, int[] price, int idx, int rodLength){
        if(idx < 0) return 0;
        if(dp[rodLength][idx] != -1) return dp[rodLength][idx];
        int cut = 0;
        if(rodLength >= idx+1)
             cut = price[idx] + solve(dp, price, idx, rodLength - (idx+1));
        int notCut = solve(dp, price, idx-1, rodLength);
        
        return dp[rodLength][idx] = Math.max(cut, notCut);
    }
}