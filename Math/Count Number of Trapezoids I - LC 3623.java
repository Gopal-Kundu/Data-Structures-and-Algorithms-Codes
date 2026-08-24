//https://leetcode.com/problems/count-number-of-trapezoids-i/description

class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1000000007;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] point : points){
            map.put(point[1], map.getOrDefault(point[1], 0)+1);
        }

        long ans = 0;
        long sum = 0;
        for(int dots : map.values()){
            long edges = (long)dots*(dots-1)/2;
            System.out.print("edges "+ edges);
            ans = (ans + edges*sum)%mod;
            sum = (sum + edges)%mod;
        }
        return (int)ans; 
    }
}