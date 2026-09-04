//https://leetcode.com/problems/01-matrix/description/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>(); //{R,C,Dist}
        int n = mat.length, m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(mat[r][c] == 0){
                    q.offer(new int[]{r, c, 0}); //dist from 0 to 0 is 0.
                    visited[r][c] = true;
                }
            }
        }
        int[][] dis = new int[n][m];
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] node = q.poll();
                int row = node[0], col = node[1], dist = node[2];
                dis[row][col] = dist;
                int[] x = {-1, 1, 0, 0};
                int[] y = {0, 0, -1, 1};
                for(int j = 0; j < 4; j++){
                    int nr = row + x[j], nc = col + y[j];
                    if(nr >= 0 && nc < m && nr < n && nc >= 0 && !visited[nr][nc]){
                        q.offer(new int[]{nr, nc, dist+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return dis;
    }
}