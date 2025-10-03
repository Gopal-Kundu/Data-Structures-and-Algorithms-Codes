// https://leetcode.com/problems/last-stone-weight-ii/

//Brute Force giving TLE
class Solution {
    public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for(int stone : stones)
        sum+=stone;
        int target = sum/2;

      int max_to_far[] = new int[1];
      findMax(stones, max_to_far, 0, 0, target);
      return sum - 2 * max_to_far[0];
    }
    void findMax(int[] stones,int[] max_to_far, int idx, int sum, int target){
        if(sum <= target)
            max_to_far[0] = Math.max(max_to_far[0], sum);
        if(sum > target || idx >= stones.length) return;

        findMax(stones, max_to_far, idx+1, sum+stones[idx], target);
        findMax(stones, max_to_far, idx+1, sum, target);
        return;
    }
}