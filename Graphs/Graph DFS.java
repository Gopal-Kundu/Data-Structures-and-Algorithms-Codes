void DFS(int[][] isConnected, boolean[] visited, int start){
        visited[start] = true;
        for(int i = 0; i < isConnected[0].length; i++){
            if(!visited[i] && isConnected[start][i] == 1)
                DFS(isConnected, visited, i);
        }
    }