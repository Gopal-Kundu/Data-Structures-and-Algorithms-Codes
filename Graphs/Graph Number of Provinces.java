//https://leetcode.com/problems/number-of-provinces/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        //Solving using BFS
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                cnt++;
                DFS(isConnected, visited, i);
            }
        }
        return cnt;
    }
    void DFS(int[][] isConnected, boolean[] visited, int start){
        visited[start] = true;
        for(int i = 0; i < isConnected[0].length; i++){
            if(!visited[i] && isConnected[start][i] == 1)
                DFS(isConnected, visited, i);
        }
    }

    void BFS(int[][] isConnected, boolean[] visited, int start){
        int n = isConnected.length;
        int m = isConnected[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                visited[node] = true;
                for(int j = 0; j < m; j++){
                    if(isConnected[node][j] == 1 && !visited[j]){
                        q.offer(j);
                    }
                }
            }
        } 
    }
}