//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

function maxProfit(prices: number[]): number {
    if(prices.length <= 1) return 0; 
    let buy: number = prices[0];
    let sell: number = -1e9;
    let profit: number = 0;
    for(let i = 1; i < prices.length; i++){
        profit = Math.max(prices[i] - buy, profit);
        if(prices[i] < buy)
            buy = prices[i];
    }
    return profit;
};