// https://leetcode.com/problems/triangle/description/

//Brute force
class Solution {
    int solve(List<List<Integer>> triangle, int row, int col){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        int left = solve(triangle, row+1, col);
        int right = solve(triangle, row+1, col+1);
        return triangle.get(row).get(col) + Math.min(left, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle, 0, 0);
    }
}

//Using Dp top-down
class Solution {
    int solve(List<List<Integer>> triangle, int[][] dp, int row, int col){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        int left = solve(triangle, dp, row+1, col);
        int right = solve(triangle, dp, row+1, col+1);
        return dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int dp[][] = new int[row][col];
        for(int i[] : dp)
            Arrays.fill(i, Integer.MAX_VALUE);
        
        return solve(triangle, dp, 0, 0);
    }
}

