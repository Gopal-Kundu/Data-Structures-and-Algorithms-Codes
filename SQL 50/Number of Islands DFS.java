    void DFS(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int x[] = { -1, +1, 0, 0 };
        int y[] = { 0, 0, -1, +1 };
        for (int i = 0; i < 4; i++) {
            int nrow = row + x[i];
            int ncol = col + y[i];
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length) {
                if (!visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                    DFS(grid, visited, nrow, ncol);
                }
            }
        }
    }