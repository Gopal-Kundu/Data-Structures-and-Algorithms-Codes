//https://www.geeksforgeeks.org/problems/triangle-path-sum/1

class Solution {
    int memo[][];
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        memo = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);
            
        return solve(triangle, 0, 0);
    }
    int solve(ArrayList<ArrayList<Integer>> triangle, int row, int col){
        if(row >= triangle.size() || col >= triangle.get(row).size()) return 0;
        if(memo[row][col] != -1) return memo[row][col];
        int down = solve(triangle, row+1, col) + triangle.get(row).get(col);
        int right = solve(triangle, row+1, col+1) + triangle.get(row).get(col);
        
        return memo[row][col] = Math.min(down, right);
    }
}