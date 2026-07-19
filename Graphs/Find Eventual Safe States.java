//https://leetcode.com/problems/find-eventual-safe-states/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int pathVis[] = new int[V];
        int safeNodes[] = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0)
                checkCycleDFS(graph, i, vis, pathVis, safeNodes);
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < V; i++)
            if(safeNodes[i] == 1) answer.add(i);
        
        return answer;
    }
    public boolean checkCycleDFS(int[][] graph, int start, int[] vis, int[] pathVis, int[] safeNodes){
        vis[start] = 1;
        pathVis[start] = 1;
        for(int node : graph[start]){
            if(vis[node] == 0){
                if(checkCycleDFS(graph, node, vis, pathVis, safeNodes) == true)
                    return true;
            }else{
                if(vis[node] == 1 && pathVis[node] == 1) 
                    return true; //Cycle found
            }
        }
        safeNodes[start] = 1;
        pathVis[start] = 0;
        return false;
    }
}