//https://leetcode.com/problems/matchsticks-to-square/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0; 
        for(int num : matchsticks) sum+=num;
        if(sum%4 != 0) return false;
        Arrays.sort(matchsticks); 
        return canFormSquare(matchsticks, matchsticks.length-1, sum/4, new int[4]);
    }
    boolean canFormSquare(int[] matchsticks, int idx, int target, int[] pos){
        if(idx == -1){
            if(pos[0] == target && pos[1] == target &&
            pos[2] == target && pos[3] == target) return true;
            else return false;
        };
        for(int i = 0; i < 4; i++){
            if(pos[i] + matchsticks[idx] <= target){
                pos[i] += matchsticks[idx];
                if(canFormSquare(matchsticks, idx-1, target, pos)) return true;
                pos[i] -= matchsticks[idx];
            }
        }
        return false;
    }
}