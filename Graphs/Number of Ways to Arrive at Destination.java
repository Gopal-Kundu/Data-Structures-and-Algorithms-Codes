//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new long[] { v, w });
            adj.get(v).add(new long[] { u, w });
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        long[] ways = new long[n];
        ways[0] = 1;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });
        q.offer(new long[] { 0, 0 });
        int MOD = (int) (1e9 + 7);
        while (!q.isEmpty()) {
            var info = q.poll();
            int node = (int)info[1];
            long weight = info[0];
            for (long[] p : adj.get(node)) {

                int next = (int) p[0];
                long edgeWeight = p[1];

                long newDist = weight + edgeWeight;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    q.offer(new long[] {newDist, next });
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        return (int) ways[n - 1] % MOD;
    }
}s