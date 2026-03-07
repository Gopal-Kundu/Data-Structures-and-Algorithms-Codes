//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int count = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 'L'){
                    dfs(row, col, grid); count++;
                }
            }
        }
        return count;
    }
    void dfs(int row, int col, char[][] grid){
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 'W') 
            return;

        grid[row][col] = 'W';
        int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i = 0; i < 8; i++){
            dfs(row + dr[i], col + dc[i], grid);
        }
        return;
    }
}