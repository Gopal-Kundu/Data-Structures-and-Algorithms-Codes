//https://leetcode.com/problems/course-schedule-ii/description

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Convert to adjecency list.
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!adjList.containsKey(prerequisites[i][1]))
                adjList.put(prerequisites[i][1], new ArrayList<>());
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //Creating indegree array.
        int[] indegree = new int[numCourses];
        for (int i : adjList.keySet()) {
            for (int neighbor : adjList.get(i)) {
                indegree[neighbor]++;
            }
        }

        //Creating queue to track independent courses
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0)
                q.offer(i);

        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx] = node;
            idx++;
            if (adjList.containsKey(node)) {
                for (int i : adjList.get(node)) {
                    indegree[i]--;
                    if (indegree[i] == 0)
                        q.offer(i);
                }
            }

        }
        if (idx < numCourses)
            return new int[0];
        return ans;
    }
}