//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if(start == end) return 0;
        // code here
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        int[] dist = new int[1000];
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int node = p[0];
            int w = p[1];
            for(int a : arr){
                int n = (a*node)%1000;
                if(n == end) return w+1;
                if(w + 1 < dist[n]){
                    dist[n] = w + 1;
                    q.offer(new int[]{n, w+1});
                }
            }
        }
        return -1;
    }
}