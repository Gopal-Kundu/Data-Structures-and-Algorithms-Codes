//https://leetcode.com/problems/course-schedule/description

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Convert to adjecency list.
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!adjList.containsKey(prerequisites[i][1]))
                adjList.put(prerequisites[i][1], new ArrayList<>());
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        if (adjList.size() == 0)
            return true;
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

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            if (adjList.containsKey(node)) {
                for (int i : adjList.get(node)) {
                    indegree[i]--;
                    if (indegree[i] == 0)
                        q.offer(i);
                }
            }

        }
        if (count < numCourses)
            return false;
        return true;
    }
}