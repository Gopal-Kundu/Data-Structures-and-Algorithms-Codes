https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[arr.length][sum+1]; //Default False;
        //Variable ending point
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= sum; j++){
                boolean ls = false;
                boolean rs = false;
                if(j - arr[i] >= 0)
                    ls = dp[i-1][j - arr[i]];
                rs = dp[i-1][j];
                
                dp[i][j] = ls | rs;
            }
        }
        return dp[n-1][sum];
    }
}