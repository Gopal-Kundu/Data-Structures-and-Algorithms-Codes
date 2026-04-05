//https://leetcode.com/problems/bag-of-tokens/description/

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length-1;
        int maxScore = 0, currScore = 0;
        while(i <= j){
            if(power >= tokens[i]){
                maxScore = Math.max(maxScore, ++currScore);
                power -= tokens[i];
                i++;
            }else if(currScore >= 1){
                power+=tokens[j];
                currScore--;
                j--;
            }else break;
        }
        return maxScore;
    }
}