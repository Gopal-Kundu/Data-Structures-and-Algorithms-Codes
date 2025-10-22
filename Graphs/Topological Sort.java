/* 
Sorting algorithm for directed Graphs
 5 -> 4-> 3 ans [5,4,3] 
 If there is edge between u and v then [u -> v]
 Only possible in Acycle directed graph
-----------------------------------------------------------------------
 To ways to do ( Khan's Algo and DFS )
-----------------------------------------------------------------------
Intuition for khan's Algo is remove all incoming edges for a vertex then move to next vertex. Incoming edge is known as indegree.
1. Need a indegree array (According to graph size)
2. Increment the array's value according to incoming edge. 0->[5,3] incoming edge is 5 and 3.
3. Need a queue. [store all 0 value i mean no incoming edges array index]
4. Then in queue get the incoming edge array index and decrement 1 in the indegree in array according to given data. 
Let, q = [4,0] and array has [0,3,4,5,0] and adjecency list has 4->[2,3] and 0->[3,1] then decrement 2nd index and 3rd index, array become [0,3,3,4,0] and remove/print 4 from queue, means all incoming edge deleted.

-- Main motive delete all incoming edges using array and queue. Queue stores only values with no incoming edges, array is for track the edges incoming or not. (BFS)
-- Sorting means those values whose incoming edges can removed first
----------------------------------------------------------------------------------------------------------
-- If Khan's algorithm has undirected graph then it stuck in cycle.
TC->O(V+E) + O(E) and SC-> O(V)
/*

int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj){
	
	//Part 1 array making
	int indegree[ ] = new int[v];
	for(int i = 0; i < adj.size(); i++){
	          for(int j : adj.get(i)){
		indegree[j]++;
	           }
	}

	//Part  2 Queue
	Queue<Integer> queue = new LinkedList<>();
	for(int i = 0; i < v; i++){
		if(indegree[i] == 0){
		queue.offer(i);
		}
	}

	ArrayList<Integer> ans = new ArrayList<>();
	while(!queue.isEmpty){ //Process until queue empty
	int node = queue.poll();
	ans.add(node);
	for(int neighbout : adj.get(node)){
		indegree[neighbour]--;
		if(indegree[neighbour] == 0)
			queue.offer(neighbour);	
	}

}
//Cycle check if (ans.size() < v) means if after sorting if size of sorted list is less than total vertices.
	return ans;
}
//-------------------------------------------------------------------------------------------------------

//Topo sort using DFS
/*
1. Need a boolean visited array. (Visit all nodes and when found no edge return)
2. Need a Stack. (Push all nodes after visited all incoming nodes)
Insert in stack if vertex has no neighbour.
*/









 