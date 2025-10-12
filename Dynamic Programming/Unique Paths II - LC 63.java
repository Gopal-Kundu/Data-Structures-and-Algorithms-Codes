// https://leetcode.com/problems/unique-paths-ii/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        boolean isObAtRow = false;
        boolean isObAtCol = false;
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid[row - 1][col - 1] == 1)
            return 0;
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    if (isObAtRow || obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        isObAtRow = true;
                    } else
                        dp[i][j] = 1;
                }
                else if (j == 0) {
                    if (isObAtCol || obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        isObAtCol = true;
                    } else
                        dp[i][j] = 1;
                } else {
                    if (obstacleGrid[i][j] == 1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}