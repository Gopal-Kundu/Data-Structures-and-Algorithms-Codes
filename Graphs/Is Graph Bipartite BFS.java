//https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int colour[] = new int[graph.length];
        Arrays.fill(colour, -1);

        for(int i = 0; i < graph.length; i++){
            if(colour[i] == -1){
                if(BFS(graph, i, colour) == false) 
                    return false;
            }
        }
        return true;
    }
    boolean BFS(int[][] graph, int start, int[] colour){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colour[start] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                int color = colour[node];
                for(int n : graph[node]){
                    if(colour[n] != -1){
                        if(colour[n] == color) return false;
                    }else{
                        colour[n] = (color == 0 ? 1 : 0);
                        q.offer(n);
                    }
                } 
            }
        }

        return true;
    }
}