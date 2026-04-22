//https://leetcode.com/problems/maximum-number-of-coins-you-can-get/


class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int j = n-2;
        int myPiles = 0;
        int total = 0;

        while(total != n/3){
            myPiles += piles[j];
            j-=2;
            total++;
        }
        return myPiles;
    }
}