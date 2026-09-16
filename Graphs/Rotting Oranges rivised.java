//https://leetcode.com/problems/rotting-oranges/

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            if(fresh == 0) break;
            int size = q.size();
            cnt++;
            for(int i = 0; i < size; i++){
                int r1 = q.peek()[0];
                int c1 = q.poll()[1];
                int x[] = {1, -1, 0, 0};
                int y[] = {0, 0, 1, -1};
                for(int j = 0; j < 4; j++){
                    int row = r1 + x[j], col = c1 + y[j];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                    && grid[row][col] == 1){
                        q.offer(new int[]{row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
        }
        return fresh != 0 ? -1 : cnt;
    }
}