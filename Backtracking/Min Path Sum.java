//https://leetcode.com/problems/minimum-path-sum/

class Solution {
        int memo[][];
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);
        return solve(grid, m-1, n-1);
    }
        private int solve(int[][] mat, int i, int j) {
        if (i < 0 || j < 0)
            return (int)1e9;
        if (i == 0 && j == 0)
            return mat[i][j];
        if (memo[i][j] != -1)
            return memo[i][j];
        int up = mat[i][j] + solve(mat, i - 1, j);
        int left = mat[i][j] + solve(mat, i, j - 1);

        return memo[i][j] = Math.min(up,left);
    }
}