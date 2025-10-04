// https://leetcode.com/problems/coin-change/description/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int minCoinsReq[] = new int[amount+1];
        for(int i = 1; i <= amount; i++){
            minCoinsReq[i] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= i && minCoinsReq[i - coin] != Integer.MAX_VALUE )
                minCoinsReq[i] = Math.min(minCoinsReq[i], 1 + minCoinsReq[i - coin]);
            }
        }
        return minCoinsReq[amount] != Integer.MAX_VALUE ? minCoinsReq[amount] : -1;
    }
}