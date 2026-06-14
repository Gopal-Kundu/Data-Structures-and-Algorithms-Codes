//https://leetcode.com/problems/network-delay-time/description/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //AdjecencyList creation
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adjList.get(times[i][0]).add(new int[] { times[i][1], times[i][2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { k, 0 });

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int nodeDist = curr[1];
            //Avoid Multiple Entries
            if (dist[node] < nodeDist) continue;

            for (int[] nodes : adjList.get(node)) {
                int w = nodes[1];
                int dest = nodes[0];
                // relaxation
                if (dist[node] + w < dist[dest]) {
                    dist[dest] = dist[node] + w;
                    pq.offer(new int[] { dest, dist[dest] });
                }
            }
        }

        //Check all nodes, if they are non-reachable
        System.out.println(Arrays.toString(dist));
        int minimumTime = -1;
        for (int i = 1; i <= n; i++) {
            minimumTime = Math.max(minimumTime, dist[i]);
        }

        return minimumTime == (int)1e9 ? -1 : minimumTime;
    }
}