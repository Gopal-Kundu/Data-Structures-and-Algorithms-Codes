//https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int colour[] = new int[graph.length];
        Arrays.fill(colour, -1);

        for(int i = 0; i < graph.length; i++){
            if(colour[i] == -1){
                if(DFS(graph, i, colour, 0) == false) 
                    return false;
            }
        }
        return true;
    }
    boolean DFS(int[][] graph, int start, int[] colour, int color){
        colour[start] = color;
        for(int n : graph[start]){
            if(colour[n] == -1){
                if(DFS(graph, n, colour, (color == 0 ? 1 : 0)) == false)
                    return false;
            }else{
                if(color == colour[n]) return false;
            }
        }
        return true; 
    }
}