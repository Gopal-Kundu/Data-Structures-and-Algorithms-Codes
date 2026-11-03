//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount, 0);
        return ans >= (int)1e9 ? -1 : ans;   
    }

    int solve(int[] coins, int amount, int idx){
        if(amount == 0) return 0;
        if(amount < 0) return (int)1e9;
        int min = (int) 1e9;
        for(int i = idx; i < coins.length; i++){
            min = Math.min(1 + solve(coins, amount - coins[i], i), min);
        }
        return min >= (int) 1e9 ? (int)1e9 : min; 
    }
}