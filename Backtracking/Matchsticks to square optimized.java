//https://leetcode.com/problems/matchsticks-to-square/
class Solution {
    int len = 0;

    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += matchsticks[i];
        if (sum % 4 != 0)
            return false;
        len = sum / 4;
        return backTrack(matchsticks, 0, 4, sum / 4, new HashSet<>());
    }

    boolean backTrack(int[] matchsticks, int i, int sides, int target, HashSet<Integer> used) {
        if (sides == 0)
            return true;
        if (target < 0)
            return false;
        if (i == matchsticks.length || target == 0) {
            if (target == 0) {
                return backTrack(matchsticks, 0, sides - 1, len, used);
            }
            return false;
        }

        if (!used.contains(i)) {
            used.add(i);
            if (backTrack(matchsticks, i + 1, sides, target - matchsticks[i], used))
                return true;
            used.remove(i);
        }
        
        if (backTrack(matchsticks, i + 1, sides, target, used))
            return true;
        return false;
    }
}