//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<String> result = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 'L'){
                    HashSet<String> set = new HashSet<>();
                    DFS(grid, visited, set, i, j, i, j);
                    result.add(set + "");
                }
            }
        }
        return result.size();
    }
    void DFS(char[][] grid, boolean[][] visited, 
    HashSet<String> set, int row, int col, int brow, int bcol){
        int m = grid.length, n = grid[0].length;
        if(row > m-1 || row < 0 || col > n-1 || col < 0 
        || visited[row][col] || grid[row][col] == 'W') return;
        
        visited[row][col] = true;
        set.add(convert(row, col, brow, bcol));
        
        DFS(grid, visited, set, row+1, col, brow, bcol);
        DFS(grid, visited, set, row, col+1, brow, bcol);
        DFS(grid, visited, set, row-1, col, brow, bcol);
        DFS(grid, visited, set, row, col-1, brow, bcol);
    }
    
    String convert(int row, int col, int baseRow, int baseCol){
        return (row - baseRow) + "," + (col - baseCol);
    }
}