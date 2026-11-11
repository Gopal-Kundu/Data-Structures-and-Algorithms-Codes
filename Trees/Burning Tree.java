//https://www.geeksforgeeks.org/problems/burning-tree/1

/* Structure of binary tree node
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		left = right = null;
	}
} */

class Solution {
	public int minTime(Node root, int target) {
		// code here
		HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
		makeAdj(adj, root, -1);
		if (!adj.containsKey(target))
			return 0;
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		q.add(target); visited.add(target);
		int time = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int rt = q.poll();
				for (int node : adj.get(rt)) {
					if (!visited.contains(node)) {
						q.offer(node);
						visited.add(node);
					}
				}
			}
			time++;
		}
		return time;
	}
	
	void makeAdj(HashMap<Integer, ArrayList<Integer>> adj, Node root, int parent) {
		if (root == null)
			return;
		if (!adj.containsKey(root.data))
			adj.put(root.data, new ArrayList<>());
		if (parent != -1)
			adj.get(root.data).add(parent);
		if (root.left != null)
			adj.get(root.data).add(root.left.data);
		if (root.right != null)
			adj.get(root.data).add(root.right.data);
		makeAdj(adj, root.left, root.data);
		makeAdj(adj, root.right, root.data);
	}
}
