//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
    public int maxProfit(int[] prices) {
        int sell = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > sell)
                profit += prices[i] - sell;
            sell = prices[i];
        }
        return profit;
    }
}