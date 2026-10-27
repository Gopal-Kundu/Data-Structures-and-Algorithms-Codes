//https://leetcode.com/problems/find-k-closest-elements/description/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length; List<Integer> res = new ArrayList<>();
        if(n < k) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                int aDist = a[0];
                int bDist = b[0];
                if(aDist == bDist) return a[1] - b[1];
                return a[0] - b[0]; 
            }
        );
        //[2, 1] [1, 2] [0, 3] [1, 4] [2, 5] //Example-1
        for(int i = 0; i < n; i++)
            pq.offer(new int[]{Math.abs(arr[i] - x), arr[i]});
        while(k != 0){
           res.add(pq.poll()[1]);
           k--;
        }
        Collections.sort(res);
        return res;
    }
}