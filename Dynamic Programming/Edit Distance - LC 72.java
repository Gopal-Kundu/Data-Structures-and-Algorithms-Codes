// https://leetcode.com/problems/edit-distance/

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] memo = new int[n][m];
        return getMinDistance(0, 0, word1, word2, memo);
    }

    int getMinDistance(int i, int j, String w1, String w2, int[][] memo){
        int n = w1.length();
        int m = w2.length();
        if(i == n) return m - j;
        if(j == m) return n - i;
        if(memo[i][j] != 0) return memo[i][j];
        if(w1.charAt(i) == w2.charAt(j))
            return memo[i][j] = getMinDistance(i+1, j+1, w1, w2, memo);
        
        int insert = getMinDistance(i, j+1, w1, w2, memo);
        int delete = getMinDistance(i+1, j, w1, w2, memo);
        int replace = getMinDistance(i+1, j+1, w1, w2, memo);

        return memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}