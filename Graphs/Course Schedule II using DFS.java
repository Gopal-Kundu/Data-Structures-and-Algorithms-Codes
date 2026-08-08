//https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < N; i++){
            if(vis[i] == 0){
                if(DFS(adj, vis, i, pathVis, stk) == true) 
                    return new int[]{};
            }
        }

        int[] result = new int[N]; int i = 0;
        while(!stk.isEmpty()) result[i++] = stk.pop();
        return result;
    }

    boolean DFS(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, int[] pathVis, Stack<Integer> stk) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int n : adj.get(node)) {
            if (vis[n] == 0) {
                if (DFS(adj, vis, n, pathVis, stk) == true)
                    return true;
            } else {
                if (pathVis[n] == 1)
                    return true;
            }
        }
        pathVis[node] = 0;
        stk.add(node);
        return false;
    }
}