//https://leetcode.com/problems/min-cost-climbing-stairs/description/
class Solution {
    int memo[];

    public Solution() {
        memo = new int[1001];
        Arrays.fill(memo, -1);
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(findMinCost(cost, memo, 0),findMinCost(cost, memo, 1));
    }

    private int findMinCost(int[] cost, int[] memo, int idx) {
        if (idx >= cost.length)
            return 0;
        if (memo[idx] != -1)
            return memo[idx];
        int sum1 = cost[idx] + findMinCost(cost, memo, idx + 1);
        int sum2 = cost[idx] + findMinCost(cost, memo, idx + 2);
        memo[idx] = Math.min(sum1, sum2);
        return memo[idx];
    }
}