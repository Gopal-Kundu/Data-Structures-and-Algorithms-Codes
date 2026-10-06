class Solution {
    public boolean detectCycle(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int pathVis[] = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0)
                if(checkCycleDFS(graph, i, vis, pathVis) == true)
		return true;
        }
        
        return false;
    }
    public boolean checkCycleDFS(int[][] graph, int start, int[] vis, int[] pathVis){
        vis[start] = 1;
        pathVis[start] = 1;
        for(int node : graph[start]){
            if(vis[node] == 0){
                if(checkCycleDFS(graph, node, vis, pathVis) == true)
                    return true;
            }else{
                if(vis[node] == 1 && pathVis[node] == 1) 
                    return true; //Cycle found
            }
        }
        pathVis[start] = 0;
        return false;
    }
}