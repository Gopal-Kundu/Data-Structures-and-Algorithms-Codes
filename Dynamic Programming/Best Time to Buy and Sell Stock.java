// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
We can buy on min price day and sell everyday to check maximum profit.
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++){
            min = Math.min(min,prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}