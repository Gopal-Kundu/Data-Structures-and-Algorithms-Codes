class Solution {
    int minCost(int[] height) {
        // code here
        return solve(height, height.length-1);
    }
    private int solve(int[] height, int idx){
        if(idx == 0) return 0;
        int step1 = solve(height, idx-1) + Math.abs(height[idx] - height[idx-1]);
        int step2 = Integer.MAX_VALUE;
        if(idx > 1) step2 = solve(height, idx-2) + Math.abs(height[idx] - height[idx-2]);
        return Math.min(step1, step2);
    }
}
//---------------------------
//Optimal

class Solution {
    int memo[];
    int minCost(int[] height) {
        // code here
        memo = new int[height.length];
        Arrays.fill(memo, -1);
        return solve(height, height.length-1, memo);
    }
    private int solve(int[] height, int idx, int[] memo){
        if(idx == 0) return 0;
        if(memo[idx] != -1) return memo[idx];
        int step1 = solve(height, idx-1, memo) + Math.abs(height[idx] - height[idx-1]);
        int step2 = Integer.MAX_VALUE;
        if(idx > 1) step2 = solve(height, idx-2, memo) + Math.abs(height[idx] - height[idx-2]);
        return memo[idx] = Math.min(step1, step2);
    }
}