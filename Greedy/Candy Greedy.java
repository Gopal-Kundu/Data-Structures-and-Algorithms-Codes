//https://leetcode.com/problems/candy/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i = n-2; i >= 0; i--){
            if(ratings[i+1] < ratings[i]){
                int maxCandyPossible = Math.max(candies[i], candies[i+1] + 1);
                candies[i] = maxCandyPossible;
            }
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            total += candies[i];
        }
        return total;
    }
}