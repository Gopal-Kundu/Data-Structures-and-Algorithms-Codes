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