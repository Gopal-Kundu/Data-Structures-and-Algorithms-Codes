//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[][] graph = new int[v][v];
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        int[] coloursOfNode = new int[v];
        return solve(0, coloursOfNode, graph, m);
    }
    
    boolean solve(int node, int[] coloursOfNode, int[][] graph, int m){
        if(node == graph.length) return true; //All vertices covered;
        
        for(int colour = 1; colour <= m; colour++){
            if(isPossible(node, graph, coloursOfNode, colour)){
                coloursOfNode[node] = colour;
                if(solve(node+1, coloursOfNode, graph, m)) return true;
                coloursOfNode[node] = 0;
            }
        }
        return false;
    }
    
    boolean isPossible(int node, int[][] graph, int[] coloursOfNode, int colour){
        for(int currNode = 0; currNode < graph.length; currNode++){
            if(graph[node][currNode] == 1 && coloursOfNode[currNode] == colour){
                //Means adjacency nde has same colour 
                return false;
            }
        }
        return true;
    }
}