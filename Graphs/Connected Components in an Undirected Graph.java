//https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1

class Solution {
    ArrayList<ArrayList<Integer>> answer;
    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph;
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        answer = new ArrayList<>();
        graph = new ArrayList<>();
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
        
        for(int row[] : edges){
            graph.get(row[0]).add(row[1]);
            graph.get(row[1]).add(row[0]);
        }
        
        visited = new boolean[V];
        ArrayList<Integer> current;
        
        for(int node = 0; node < V; node++){
            if(!visited[node]){
                current = new ArrayList<>();
                dfs(node, current);
                answer.add(current);
            }
        }
        return answer;
    }
    
    void dfs(int node, ArrayList<Integer> current){
        if(visited[node]) return;
        
        visited[node] = true;
        current.add(node);
        for(int v : graph.get(node)){
            dfs(v, current);
        }
        return;
        
    }
}