//https://leetcode.com/problems/cherry-pickup-ii/

class Solution {
    int rows, cols;
    public int cherryPickup(int[][] grid) {
     int col1 = 0, col2 = grid[0].length-1, row = 0;
     rows = grid.length; cols = grid[0].length;
     int[][][] dp = new int[rows][cols][cols];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
     return solve(grid, row, col1, col2, dp);
    }

    int solve(int[][] grid, int row, int col1, int col2, int[][][] dp){
        if(col1 < 0 || col2 < 0 || col1 > cols-1 || col2 > cols-1 ) 
            return (int)-1e8;
        if(row == grid.length-1){
            if(col1 == col2) return grid[row][col1];
            else return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
        int max = (int)-1e8;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int value = 0;
                    if(col1 == col2) 
                        value += grid[row][col1];
                    else 
                        value += grid[row][col1] + grid[row][col2];
                    value += solve(grid, row+1, col1 + i, col2 + j, dp);
                max = Math.max(max, value);
            }
        }
        return dp[row][col1][col2] = max;
    }
}