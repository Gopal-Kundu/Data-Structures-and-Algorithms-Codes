//https://leetcode.com/problems/unique-paths/

class Solution {
    int memo[][];
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);

        return solve(m-1, n-1);
    }

    private int solve(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;
        if(memo[i][j] != -1) return memo[i][j];
        int up = solve(i-1, j);
        int left = solve(i, j-1);

        return memo[i][j] = up + left;
    }
}
