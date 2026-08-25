//https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    cnt++;
                    BFS(grid, visited, row, col);
                }
            }
        }
        return cnt;
    }

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

    void BFS(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        int x[] = { -1, +1, 0, 0 };
        int y[] = { 0, 0, -1, +1 };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int node[] = q.poll();
                int r = node[0], c = node[1];
                for (int i = 0; i < 4; i++) {
                    int nrow = r + x[i];
                    int ncol = c + y[i];
                    if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length) {
                        if (!visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                            q.offer(new int[]{nrow, ncol});
                            visited[nrow][ncol] = true;
                        }
                    }
                }
            }
        }
    }
}