// https://leetcode.com/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {
        if(nums[0] == 0) return 0;
        
        int curr = 0, jumps = 0;
        int maxWeGo = nums[0];
        while(curr < nums.length-1){
            int start = curr;
            int end = curr + nums[curr];
            for(int i = start+1; i <= end; i++){
                if(i < nums.length-1){
                    if(maxWeGo <= nums[i] + i){
                        maxWeGo = nums[i] + i;
                        curr = i;
                    }
                }else{
                    curr = nums.length; //Assume we reached max
                    break;
                }
            }
            jumps++;
        }
        return jumps;
    }
}