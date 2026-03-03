// https://leetcode.com/problems/climbing-stairs/description/

class Solution {
    int[] memo = new int[45+1];
    public Solution() {
        Arrays.fill(memo, -1);
    }
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != -1) return memo[n];
        memo[n] = climbStairs(n-1)+climbStairs(n-2);
        return memo[n];        
    } 
}

//If we visualise recursion tree.
// From 2 we goes to 0 via 2 steps and return 1
// We then goes to  1 via 1 step and then again 1 step to reach 0. 
// Count total routes. We have total no of ways.
// Now we have multiple same steps so we can store them.