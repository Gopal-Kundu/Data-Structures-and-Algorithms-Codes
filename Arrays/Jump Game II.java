//https://leetcode.com/problems/jump-game-ii/description/

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int currEnd = nums[0];
        int maxCanGo = nums[0];
        int n = nums.length;
        int steps = 1;
        for(int i = 0; i < n; i++){
            maxCanGo = Math.max(maxCanGo, i + nums[i]);
            
            if(currEnd >= n-1) return steps;
            else if(i == currEnd && currEnd < n-1){
                steps++;
                currEnd = maxCanGo;
            }

        }
        return steps;
    }
}