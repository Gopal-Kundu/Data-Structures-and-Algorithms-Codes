//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int des, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int flight[] : flights){
            int u = flight[0], v = flight[1], w = flight[2];
            adj.get(u).add(new int[]{v, w});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0}); //{stops, node, price}
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            var p = q.poll();
            int node = p[1];
            int money = p[2];
            int stops = p[0];
            for(int nod[] : adj.get(node)){
                
                    if(stops > k) continue;

                    if(money + nod[1] < dist[nod[0]]){
                        dist[nod[0]] = money + nod[1];
                        q.offer(new int[]{stops+1, nod[0], money + nod[1]});
                    }
            }
        }

        return dist[des] == (int)1e9 ? -1 : dist[des];
    }
}
