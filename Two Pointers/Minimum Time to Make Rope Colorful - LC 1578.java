// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        char previousColor = colors.charAt(0);
        int idxOfPreviousColor = 0;
        int minTimeNeed = 0;
        for(int idxOfIthColor = 1; idxOfIthColor < colors.length(); idxOfIthColor++){
            if(colors.charAt(idxOfIthColor) == previousColor){
                if(neededTime[idxOfIthColor] >= neededTime[idxOfPreviousColor]){
                    minTimeNeed += neededTime[idxOfPreviousColor];
                    idxOfPreviousColor = idxOfIthColor;
                }else{
                    minTimeNeed += neededTime[idxOfIthColor];
                }
            }else{
                previousColor = colors.charAt(idxOfIthColor);
                idxOfPreviousColor = idxOfIthColor;
            }
        }
        return minTimeNeed;
    }
}