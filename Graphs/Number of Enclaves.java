//https://leetcode.com/problems/number-of-enclaves/description/


class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] marked = new boolean[m][n];
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 1 && !marked[i][0])
                DFS(grid, marked, i, 0);
            if(grid[i][n-1] == 1 && !marked[i][n-1])
                DFS(grid, marked, i, n-1);
        }

        for(int i = 0; i < grid[0].length; i++){
            if(grid[0][i] == 1 && !marked[0][i])
                DFS(grid, marked, 0, i);
            if(grid[m-1][i] == 1 && !marked[m-1][i])
                DFS(grid, marked, m-1, i);
        }
        for(int i = 0; i < m; i++){
                System.out.println(Arrays.toString(marked[i]));
        }
        int enclaves = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!marked[i][j] && grid[i][j] == 1) enclaves++;
            }
        }
        return enclaves;
    }
    void DFS(int[][] grid, boolean[][] marked, int row, int col){
        if(row > grid.length -1 || row < 0 || col < 0 || col > grid[0].length -1
        || marked[row][col]) return;
        if(grid[row][col] == 1){
            marked[row][col] = true;
            DFS(grid, marked, row+1, col);
            DFS(grid, marked, row-1, col);
            DFS(grid, marked, row, col-1);
            DFS(grid, marked, row, col+1);
        }
    }
}