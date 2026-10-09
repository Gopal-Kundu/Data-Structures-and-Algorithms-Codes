//https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = numCourses;
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        int[] vis = new int[N];
        int[] pathVis = new int[N];

        for(int i = 0; i < N; i++){
            if(vis[i] == 0){
                if(DFS(adj, vis, i, pathVis) == true) 
                    return false;
            }
        }
        return true;
    }

    boolean DFS(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int n : adj.get(node)){
            if(vis[n] == 0){
                if(DFS(adj, vis, n, pathVis) == true) return true;
            }else{
                if(pathVis[n] == 1) return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}