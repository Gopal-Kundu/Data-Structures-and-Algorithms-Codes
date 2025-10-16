// https://leetcode.com/problems/jump-game/description/

class Solution {
    public boolean canJump(int[] nums) {
        int maxWeGo = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxWeGo) return false;
            maxWeGo =  Math.max(maxWeGo, i + nums[i]);
        }
        return true;
    }
}