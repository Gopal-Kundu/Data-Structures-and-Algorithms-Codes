//https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        //Minimum candy possible is 1 for each children
        if (ratings.length == 1)
            return 1;

        int minCandyPossible[] = new int[ratings.length];
        Arrays.fill(minCandyPossible, 1);

        //Giving candy for right neighbors
        for (int child = 1; child < ratings.length; child++) {
            if (ratings[child] > ratings[child - 1])
                minCandyPossible[child] = minCandyPossible[child - 1] + 1;
        }

        //Giving candy for left neighbors
        int totalCandy = 0;
        for (int child = ratings.length - 1; child > 0; child--) {
            if (ratings[child - 1] > ratings[child]) {
                minCandyPossible[child - 1] = Math.max(minCandyPossible[child - 1], minCandyPossible[child] + 1);
            }
            totalCandy += minCandyPossible[child-1];
        }

        return totalCandy + minCandyPossible[ratings.length - 1];
    }
}