//https://leetcode.com/problems/unique-paths-ii/description/

class Solution {
    int memo[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);
        return solve(obstacleGrid, m-1, n-1);
    }

    private int solve(int[][] mat, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (mat[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (memo[i][j] != -1)
            return memo[i][j];
        int up = solve(mat, i - 1, j);
        int left = solve(mat, i, j - 1);

        return memo[i][j] = up + left;
    }
}