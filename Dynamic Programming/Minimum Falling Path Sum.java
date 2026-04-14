//https://leetcode.com/problems/minimum-falling-path-sum/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = (int) 1e9;
        int len = matrix.length;

        int prev[] = new int[len]; //Default all 0

        for (int row = 0; row < len; row++) {
            int curr[] = new int[len];
            for (int col = 0; col < len; col++) {
                if (row == 0)
                    curr[col] = matrix[row][col];
                else {
                    curr[col] = (int)1e9;
                    for (int i = -1; i <= 1; i++) {
                        int dir = matrix[row][col];
                        if (col + i < 0 || col + i > len - 1)
                            dir += (int) 1e9;
                        else
                            dir += prev[col + i];
                        curr[col] = Math.min(dir, curr[col]);
                    }
                }
            }
            prev = curr;
        }

        int ans = (int) 1e9;
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, prev[i]);
        }
        return ans;
    }
}