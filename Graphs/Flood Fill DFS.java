//https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        DFS(image, visited, sr, sc, image[sr][sc], color);
        return image;

    }

    void DFS(int[][] grid, boolean[][] visited, int row, int col, int startingColour, int newCol) {
        visited[row][col] = true;
        grid[row][col] = newCol;

        int x[] = { -1, +1, 0, 0 };
        int y[] = { 0, 0, -1, +1 };
        for (int i = 0; i < 4; i++) {
            int nrow = row + x[i];
            int ncol = col + y[i];
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length) {
                if (!visited[nrow][ncol] && grid[nrow][ncol] == startingColour) {
                    DFS(grid, visited, nrow, ncol, startingColour, newCol);
                }
            }
        }
    }
}