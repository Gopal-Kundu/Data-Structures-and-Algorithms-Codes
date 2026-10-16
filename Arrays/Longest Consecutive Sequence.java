//https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int ans = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int len = 1; int val = num;
                while(set.contains(val + 1)){
                    len++;
                    val++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}